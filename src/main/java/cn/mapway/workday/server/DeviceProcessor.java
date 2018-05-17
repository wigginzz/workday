package cn.mapway.workday.server;

import cn.mapway.workday.service.MqttService;
import cn.mapway.workday.tools.Springs;
import cn.mapway.workday.ui.shared.ConstStrings;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

public class DeviceProcessor extends ChannelInboundHandlerAdapter
{

    private final static Log log= Logs.getLog(DeviceProcessor.class);

    public void channelRead(ChannelHandlerContext ctx, Object msg)  {


        log.info("ziroom received "+msg.toString());

        DeviceInformation di = ctx.attr(ZiroomChanel.attributeKey).get();
        MqttService mqttService = Springs.get(MqttService.class);
        Msg m=new Msg();
        m.data=msg.toString();
        mqttService.publish(ConstStrings.TOPIC_PREFIX + "/arrive", Json.toJson(m));
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)  {
        cause.printStackTrace();
        ctx.close();
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);

        log.info("ziroom active " );

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);

        log.info("ziroom inactive ");
    }
}
