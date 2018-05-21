package cn.mapway.workday.server;

import cn.mapway.workday.service.MqttService;
import cn.mapway.workday.tools.Springs;
import cn.mapway.workday.ui.shared.ConstStrings;
import cn.mapway.workday.ui.shared.module.ZiroomMessage;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

public class ZiroomBaseHandler extends ChannelInboundHandlerAdapter {
    final private static Log log = Logs.getLog(ZiroomBaseHandler.class);

    private
    MqttService mqttService;

    public final synchronized MqttService getMqttService() {
        if (mqttService == null) {
            mqttService = Springs.get(MqttService.class);
        }
        return mqttService;
    }

    public void notifyChanged(String suffix, ZiroomMessage msg) {
        getMqttService().publish(ConstStrings.TOPIC_PREFIX + suffix, Json.toJson(msg));
        log.info("MQTT> " + Json.toJson(msg));
    }
}
