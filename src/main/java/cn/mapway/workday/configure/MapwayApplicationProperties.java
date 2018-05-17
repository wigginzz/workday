package cn.mapway.workday.configure;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 配置属性
 */
@ConfigurationProperties(prefix = "mapway.application")
public class MapwayApplicationProperties {

    final static Log log = Logs.getLog(MapwayApplicationProperties.class);

    MapwayApplicationProperties() {
        log.info("construction");
    }

    /**
     * The Url.
     */
    public String url = "/mapway/*";

    UIProperties ui;

    public UIProperties getUi() {
        return ui;
    }

    public void setUi(UIProperties ui) {
        this.ui = ui;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
