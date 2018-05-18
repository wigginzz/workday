package cn.mapway.workday.ui.server;

import cn.mapway.workday.ui.shared.module.ZiroomMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.nutz.json.Json;

import java.io.UnsupportedEncodingException;

/**
 * 数据bao
 * Length  2 byte
 * encodor 1 byte
 * format  1 byte
 * data    n byte
 * crc     2 byte
 */
public class ZiroomPacket {

    public static final ByteBuf encode(ZiroomMessage msg) {
        String str = Json.toJson(msg);
        byte[] data = str.getBytes();

        int length = data.length + 6;
        ByteBuf buffer = Unpooled.directBuffer(length);
        buffer.writeByte(length >> 8 & 0xFF);
        buffer.writeByte(length & 0xFF);
        buffer.writeByte(0x00);
        buffer.writeByte(0x21);
        buffer.writeBytes(data);
        buffer.writeByte(0x00);
        buffer.writeByte(0x00);
        return buffer;
    }

    /**
     * 设备连接后发送这个数据包
     *
     * @return
     */
    public static final ByteBuf queryInfoPackage() {
        // FFFFFF0F 00000001
        ByteBuf buffer = Unpooled.directBuffer(8);
        buffer.writeByte(0xFF);
        buffer.writeByte(0xFF);
        buffer.writeByte(0xFF);
        buffer.writeByte(0x0F);
        buffer.writeByte(0x00);
        buffer.writeByte(0x00);
        buffer.writeByte(0x00);
        buffer.writeByte(0x01);
        return buffer;
    }


    public static final ZiroomMessage decode(ByteBuf buf) throws UnsupportedEncodingException {
        byte byte1 = buf.getByte(0);
        byte byte2 = buf.getByte(1);
        byte byte3 = buf.getByte(2);
        byte byte4 = buf.getByte(3);

        ZiroomMessage msg = new ZiroomMessage();

        if (byte1 == 0xFF && byte2 == 0xFF && byte3 == 0xFF && byte4 == 0xFF) {
            //这是一个设备信息上报数据包
            Integer producer = buf.readInt();//生产商
            Integer model = buf.readInt(); //设备型号
            msg = ZiroomMessage.deviceMetaMessage(producer, model);

        } else {
            int length = byte1 << 8 & 0xFF00 + byte2 & 0xFF;
            byte encoder = byte3;
            byte format = byte4;
            if (format != 0x0101 || format != 0x0201) {
                StringBuilder sb = new StringBuilder();

                sb.append(String.format("%02x", (int) (byte1 & 0XFF)));
                sb.append(String.format(" %02x", (int) (byte2 & 0XFF)));
                sb.append(String.format(" %02x", (int) (byte3 & 0XFF)));
                sb.append(String.format(" %02x", (int) (byte4 & 0XFF)));
                while (buf.isReadable()) {
                    byte b = buf.readByte();
                    sb.append(String.format(" %02x", (int) (b & 0XFF)));
                }
                msg = ZiroomMessage.deviceUnknownMessage(sb.toString());
            } else {
                byte[] data = new byte[length];
                buf.readBytes(data);
                String json = new String(data, "UTF-8");
                msg = Json.fromJson(ZiroomMessage.class, json);
            }
        }
        return msg;
    }
}
