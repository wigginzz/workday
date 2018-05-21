package cn.mapway.workday.server;

import cn.mapway.workday.service.MqttService;
import cn.mapway.workday.tools.Springs;
import cn.mapway.workday.ui.server.ZiroomPacket;
import cn.mapway.workday.ui.shared.ConstStrings;
import cn.mapway.workday.ui.shared.module.DeviceInformation;
import cn.mapway.workday.ui.shared.module.ZiroomMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutorGroup;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class ZiroomInitialize extends ZiroomBaseHandler {

    private final static Log log = Logs.getLog(ZiroomInitialize.class);


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
        log.info("ziroom inactive ");
    }

}
