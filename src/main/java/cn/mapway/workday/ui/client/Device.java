package cn.mapway.workday.ui.client;

import cn.ennwifi.webframe.ui.client.ClientContext;
import cn.ennwifi.webframe.ui.client.WebFrameEntry;
import cn.ennwifi.webframe.ui.client.main.MainFrame;
import cn.mapway.ui.client.mqtt.MqttJsClient;
import cn.mapway.workday.ui.client.module.dashboard.Dashboard;
import cn.mapway.workday.ui.shared.ConstStrings;

/**
 * main page entry.
 */
public class Device extends WebFrameEntry {

    public String getDashBoardModuleCode() {
        return Dashboard.MODULE_CODE;
    }

    public Integer getResourceRootId() {
        return 1;
    }


    @Override
    public void onModuleLoad() {
        ClientContext.getContext().setMqttTopicPrefix(ConstStrings.TOPIC_PREFIX);
        ClientContext.getContext().getEventBus().register(MainFrame.MQTT_CONNECTION_ARRIVED, this);
        super.onModuleLoad();
    }



    @Override
    public void onEvent(String topic, int type, Object event) {
        super.onEvent(topic, type, event);
        if (MainFrame.MQTT_CONNECTION_ARRIVED.equals(topic)) {
            MqttJsClient client = (MqttJsClient) event;
            client.sub(ConstStrings.TOPIC_PREFIX + "/#");

        }
    }
}
