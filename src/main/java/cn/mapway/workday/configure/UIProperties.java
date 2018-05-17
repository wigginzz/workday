package cn.mapway.workday.configure;

import cn.ennwifi.webframe.ui.shared.module.ClientConfigure;
import org.springframework.boot.context.properties.ConfigurationProperties;


public class UIProperties implements ClientConfigure {
    private String imagePrefix;
    private String imageUploadProxyUrl;
    private String apiServer;
    private String mqttServer;
    private String mqttPort;
    private String mqttPath;

    @Override
    public String getMqttPath() {
        return mqttPath;
    }

    public void setMqttPath(String mqttPath) {
        this.mqttPath = mqttPath;
    }

    @Override
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    private String logo;

    public String getMqttServer() {
        return mqttServer;
    }

    public void setMqttServer(String mqttServer) {
        this.mqttServer = mqttServer;
    }

    public String getMqttPort() {
        return mqttPort;
    }

    public void setMqttPort(String mqttPort) {
        this.mqttPort = mqttPort;
    }

    public String getImagePrefix() {
        return imagePrefix;
    }

    public void setImagePrefix(String imagePrefix) {
        this.imagePrefix = imagePrefix;
    }

    public String getImageUploadProxyUrl() {
        return imageUploadProxyUrl;
    }

    public void setImageUploadProxyUrl(String imageUploadProxyUrl) {
        this.imageUploadProxyUrl = imageUploadProxyUrl;
    }

    public String getApiServer() {
        return apiServer;
    }

    public void setApiServer(String apiServer) {
        this.apiServer = apiServer;
    }


    @Override
    public String getCompileInformation() {
        return "";
    }


}
