package cn.mapway.workday.server;

import io.netty.channel.Channel;

import java.net.Socket;

public class DeviceInformation {
    public Channel socket;
    public  String mac;
    public String time;
    public String ip;
    public String ptype;
}
