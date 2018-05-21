package cn.mapway.workday.server;

import cn.mapway.workday.service.MqttService;
import cn.mapway.workday.tools.Springs;
import cn.mapway.workday.ui.server.ZiroomPacket;
import cn.mapway.workday.ui.shared.ConstStrings;
import cn.mapway.workday.ui.shared.module.ChanelMessage;
import cn.mapway.workday.ui.shared.module.DeviceInformation;
import cn.mapway.workday.ui.shared.module.ZiroomMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.zip.ZipInputStream;

public class DeviceProcessor extends ChannelInboundHandlerAdapter {

    private final static Log log = Logs.getLog(DeviceProcessor.class);

    public final static AttributeKey<DeviceInformation> attributeKey = AttributeKey.valueOf("di");

    /**
     * 全局Sessions
     */
    private final static ConcurrentHashMap<String, ChannelHandlerContext> sessions = new ConcurrentHashMap<String, ChannelHandlerContext>();

    public static ArrayList<DeviceInformation> getAllDeviceList() {
        ArrayList<DeviceInformation> dis = new ArrayList<>();
        sessions.forEach(new BiConsumer<String, ChannelHandlerContext>() {
            @Override
            public void accept(String s, ChannelHandlerContext channelHandlerContext) {
                DeviceInformation di = channelHandlerContext.attr(attributeKey).get();
                dis.add(di);
            }
        });
        return dis;
    }

    /**
     * 获取Chanelinformation
     *
     * @param chanelId
     * @return
     */
    public final static ChannelHandlerContext getChanelContext(String chanelId) {
        return sessions.get(chanelId);
    }

    public
    MqttService mqttService;

    private final synchronized MqttService getMqttService() {
        if (mqttService == null) {
            mqttService = Springs.get(MqttService.class);
        }
        return mqttService;
    }

    /**
     * 从设备法国来的消息
     *
     * @param ctx
     * @param msg
     */
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {

        ByteBuf buffer = (ByteBuf) msg;
        ZiroomMessage ziroomMessage = ZiroomPacket.decode(buffer);
        if(ziroomMessage.type.equals("DEVICE_META")|| ziroomMessage.type.equals("DEVICE_UNKNOWN"))
        {
            ziroomMessage.attribute=ctx.channel().id().asShortText();
        }
		
		if(ziroomMessage.type.equals("DEVICE_META"))
		{
			ZiroomMessage zmsg = ZiroomMessage.deviceQueryMessage();		
			System.out.printf("send data to  " + Json.toJson(zmsg, JsonFormat.compact()));
			ctx.writeAndFlush(ZiroomPacket.encode(zmsg));
		}

        notifyChanged("/arrive", ziroomMessage);
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 设备连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);

        DeviceInformation di = new DeviceInformation();
        ctx.attr(attributeKey).set(di);
        di.channelId = ctx.channel().id().asShortText();
        sessions.put(di.channelId, ctx);

        ZiroomMessage ziroomMessage = ZiroomMessage.deviceConnectMessage(di.channelId, ctx.channel().remoteAddress().toString());
        notifyChanged("/arrive", ziroomMessage);


        //设备连接后发送查询设备型号指令
        ctx.writeAndFlush(ZiroomPacket.queryInfoPackage());
        log.info("ziroom active ");

    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        DeviceInformation di = ctx.attr(attributeKey).get();
        sessions.remove(di.channelId);
        ZiroomMessage ziroomMessage = ZiroomMessage.deviceDisconnectMessage(di.channelId);
        notifyChanged("/arrive", ziroomMessage);
    }

    private void notifyChanged(String suffix, ZiroomMessage msg) {
        getMqttService().publish(ConstStrings.TOPIC_PREFIX + suffix, Json.toJson(msg));
    }
}
