package cn.mapway.workday.server;

import cn.mapway.workday.ui.shared.module.ZiroomMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.io.UnsupportedEncodingException;
import java.util.List;
import cn.mapway.workday.ui.server.ZiroomPacket;


/**
 * Ziroom message decoder
 */
public class ZiroomDecoder extends ByteToMessageDecoder {

    private final static Log log = Logs.getLog(ZiroomDecoder.class);
    private final static int PACKAGE_ZIROOM = 0;
    private final static int PACKAGE_META = 1;
    private final static int PACKAGE_NEED_MORE_DATA = 2;
    private final static int PACKAGE_BAD = 3;


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        //读取Byte字节流 ,转化为ZiroomMessage对象,转移到下一步处理

        ZiroomMessage msg;

        //判断是否是 元数据数据包
        int needMoreData = needMoreData(byteBuf);
        switch (needMoreData) {
            case PACKAGE_ZIROOM:
                msg = parseZiroomPackage(byteBuf);
                if (msg.type.equals(ZiroomMessage.DEVICE_UNKNOWN)) {
                    msg.attribute = channelHandlerContext.channel().id().asShortText();
                }
                list.add(msg);
                log.info("package ziroom got a message package " + Json.toJson(msg));
                break;
            case PACKAGE_META:
                msg = parseMetaPackage(byteBuf);
                msg.attribute = channelHandlerContext.channel().id().asShortText();
                list.add(msg);
                log.info("got a message package " + Json.toJson(msg));
				ZiroomMessage zmsg = ZiroomMessage.deviceQueryMessage();
                log.info("send data to  " + Json.toJson(zmsg, JsonFormat.compact()));
                channelHandlerContext.writeAndFlush(ZiroomPacket.encode(zmsg));
                break;
            case PACKAGE_BAD:
                //格式不正确
                StringBuilder sb = new StringBuilder();
                int count = byteBuf.readableBytes();
                for (int i = 0; i < count; i++) {
                    byte b = byteBuf.readByte();
                    sb.append(String.format("%02x ", (int) (b & 0XFF)).toUpperCase());
                }
                msg = ZiroomMessage.deviceUnknownMessage(sb.toString());
                msg.attribute = channelHandlerContext.channel().id().asShortText();
                list.add(msg);
                log.info("got a bad message package " + Json.toJson(msg));
                break;
            case PACKAGE_NEED_MORE_DATA:
            default:
                //需要继续从字节流中获取数据.
                log.info("waiting more data...");
                break;
        }
    }

    private ZiroomMessage parseMetaPackage(ByteBuf buf) {
        //这是一个设备信息上报数据包
        byte byte1 = buf.readByte();
        byte byte2 = buf.readByte();
        byte byte3 = buf.readByte();
        byte byte4 = buf.readByte();
        byte byte5 = buf.readByte();
        byte byte6 = buf.readByte();
        byte byte7 = buf.readByte();
        byte byte8 = buf.readByte();
        byte byte9 = buf.readByte();
        byte byte10 = buf.readByte();
        byte byte11 = buf.readByte();
        byte byte12 = buf.readByte();

        Integer producer = toLong(byte5, byte6, byte7, byte8);//生产商
        Integer model = toLong(byte9, byte10, byte11, byte12); //设备型号
        buf.clear();
        return ZiroomMessage.deviceMetaMessage(producer, model);
    }

    int toInteger(byte byte1, byte byte2) {
        return (byte1 << 8 & 0xFF00) + (byte2 & 0xFF);
    }

    int toLong(byte byte1, byte byte2, byte byte3, byte byte4) {
        return (byte1 << 24 & 0xFF000000)
                + (byte2 << 16 & 0x00FF0000)
                + (byte3 << 8 & 0x0000FF00)
                + (byte4 & 0xFF);
    }

    private ZiroomMessage parseZiroomPackage(ByteBuf buf) throws UnsupportedEncodingException {
        ZiroomMessage msg;
        byte byte1 = buf.readByte();
        byte byte2 = buf.readByte();
       // log.info(String.format("length %x %x ", (int) byte1, (int) byte2));
        int length = toInteger(byte1, byte2);
        byte encoder = buf.readByte();
        byte format = buf.readByte();
        if (format == 0x11 || format == 0x21) {
            byte[] data = new byte[length - 6];
            buf.readBytes(data);
            String json = new String(data, "UTF-8");
            msg = Json.fromJson(ZiroomMessage.class, json);

        } else {
            //格式不正确
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < buf.readableBytes(); i++) {
                byte b = buf.readByte();
                sb.append(String.format("%02x ", (int) (b & 0XFF)).toUpperCase());
            }
            msg = ZiroomMessage.deviceUnknownMessage(sb.toString());
        }
		buf.clear();
        return msg;
    }

    /**
     * 试探检测数据包，是否需要更多的数据
     *
     * @param byteBuf
     * @return
     */
    public int needMoreData(ByteBuf byteBuf) {
        //从网络传入的字节数
        int count = byteBuf.readableBytes();

        if (count < 2) {
            return PACKAGE_NEED_MORE_DATA;
        }
        byte byte0 = byteBuf.getByte(0);
        byte byte1 = byteBuf.getByte(1);
        if ((byte1 == (byte) 0xFF) && (byte0 == (byte) 0xFF)) {
            //确定是元数据包 需要12个字节
            if (count >= 12) {
                return PACKAGE_META;
            } else {
                return PACKAGE_NEED_MORE_DATA;
            }
        } else {
            //确定是Ziroom数据包
            int length = (byte0 << 8 & 0xFF00) | (byte1 & 0xFF);
            //读取格式
            if (count > 4) {
                byte format = byteBuf.getByte(3);
                if (format == 0x11 || format == 0x21) {
                    //格式正确
                } else {
                    return PACKAGE_BAD;
                }
            }
            if (count >= length) {
                return PACKAGE_ZIROOM;
            } else {
                return PACKAGE_NEED_MORE_DATA;
            }
        }
    }

}
