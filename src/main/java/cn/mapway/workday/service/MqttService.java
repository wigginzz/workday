package cn.mapway.workday.service;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

@Service
public class MqttService implements MqttCallback {
    Log log = Logs.getLog(MqttService.class);

    @Value("${mqtt.qos}")
    private int qos;
    @Value("${mqtt.broker}")
    private String mqttBroker;

    @Autowired
    private MqttConnectOptions mqttConnectOptions;

    private MqttClient MQTT_CLIENT;


    /**
     * 单例获取
     *
     * @return MqttClient
     * @author Yangjy
     * @date 2018/4/12
     */

    public synchronized MqttClient getMqttClient() {
        connect();
        return MQTT_CLIENT;
    }

    /**
     * MqttClient连接服务
     *
     * @return MqttClient
     * @author Yangjy
     * @date 2018/4/12
     */
    public void connect() {

        if (MQTT_CLIENT == null) {
            try {
                log.info("MqttClient init");
                MQTT_CLIENT = new MqttClient(mqttBroker,
                        "zlink-" + InetAddress.getLocalHost().getHostAddress(), new MemoryPersistence());
                MQTT_CLIENT.setCallback(this);
            } catch (Exception e) {
                log.error("MqttClient init error", e);
            }
        }


        try {
            if (!MQTT_CLIENT.isConnected()) {
                synchronized (this) {
                    MQTT_CLIENT.connect(mqttConnectOptions);
                    // MQTT_CLIENT.subscribe("/com/ziroom/iot/zlink/#");
                    log.info("MqttClient connect status: " + MQTT_CLIENT.isConnected());
                }
            }
        } catch (Exception e) {
            log.error("mqtt connect error {}", e);
        }
    }

    /**
     * MqttClient发消息
     *
     * @return MqttClient
     * @author Yangjy
     * @date 2018/4/12
     */

    public void publish(String topic, String content) {

        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        try {
            getMqttClient().publish(topic, message);
        } catch (MqttException e) {
            log.error("mqtt publish error", e);
        }

    }

    @Override
    public void connectionLost(Throwable throwable) {
        MQTT_CLIENT=null;
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
