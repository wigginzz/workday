package cn.mapway.workday.server;

import cn.mapway.workday.service.MqttService;
import cn.mapway.workday.tools.Springs;
import cn.mapway.workday.ui.server.ZiroomPacket;
import cn.mapway.workday.ui.shared.ConstStrings;
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

public class ZiroomProcessor extends ZiroomBaseHandler {

    private final static Log log = Logs.getLog(ZiroomProcessor.class);


    /**
     * 从设备法国来的消息
     *
     * @param ctx
     * @param msg
     */
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {

        log.info("process got a message body");
        if (msg instanceof ZiroomMessage) {
            ZiroomMessage ziroomMessage = (ZiroomMessage) msg;
            notifyChanged("/arrive", ziroomMessage);
        } else {
            log.error(msg.toString());
        }


    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
