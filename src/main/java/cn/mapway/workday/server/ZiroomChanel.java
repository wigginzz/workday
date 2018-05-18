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


    @Override
    protected void initChannel(SocketChannel socketChannel) {
        socketChannel.pipeline().addLast(new DeviceProcessor());
        log.info("socket chanel initialized");
    }


}
