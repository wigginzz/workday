package cn.mapway.workday.ui.shared.module;

import com.google.gwt.safehtml.shared.annotations.IsSafeHtml;
import com.google.gwt.user.client.rpc.IsSerializable;
import io.netty.channel.Channel;

import java.net.Socket;

public class DeviceInformation implements IsSerializable {
    public String mac;
    public String time;
    public String ip;
    public String ptype;
    public String channelId;
}
