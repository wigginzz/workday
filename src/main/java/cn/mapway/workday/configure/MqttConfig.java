package cn.mapway.workday.configure;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Yangjy on 2018/4/23.
 */
@Configuration
public class MqttConfig {

    @Value("${mqtt.userName}")
    private String mqttUserName;
    @Value("${mqtt.password}")
    private String mqttPassword;
    @Value("${mqtt.broker}")
    private String mqttBroker;

    private String caCrtUrl = "cert.pem";

    @Bean
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(mqttUserName);
        mqttConnectOptions.setPassword(mqttPassword.toCharArray());
        mqttConnectOptions.setCleanSession(true);
//        try {
//            mqttConnectOptions.setSocketFactory(SslUtil.getSocketFactory(caCrtUrl));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return mqttConnectOptions;
    }


}
