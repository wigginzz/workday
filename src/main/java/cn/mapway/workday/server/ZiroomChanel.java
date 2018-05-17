package cn.mapway.workday.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.AttributeKey;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.Vector;

public class ZiroomChanel extends ChannelInitializer<SocketChannel> { //配置具体的数据处理方式

    public final static Log log = Logs.getLog(ZiroomChanel.class);

    public final static AttributeKey<DeviceInformation> attributeKey = AttributeKey.valueOf("di");

    Vector<DeviceInformation> sessions;

    ZiroomChanel() {
        sessions = new Vector<>();
    }


    @Override
    protected void initChannel(SocketChannel socketChannel) {
        socketChannel.pipeline().addLast(new DeviceProcessor());
        log.info("socket chanel initialized");
    }


    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        log.info("chanel un reg");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        DeviceInformation di = new DeviceInformation();
        di.socket = ctx.channel();
        di.ip = ctx.channel().id().asLongText();
        ctx.attr(attributeKey).set(di);
        sessions.add(di);
        log.info("ziroom active " + di.ip);

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        DeviceInformation di = ctx.attr(attributeKey).get();
        di.socket = null;
        if (di != null) {
            sessions.remove(di);
        }
        log.info("ziroom inactive ");
    }

}
