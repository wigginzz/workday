package cn.mapway.workday.configure;


import cn.ennwifi.webframe.ui.server.servlet.WebFrameServlet;
import cn.ennwifi.webframe.ui.shared.module.ClientConfigure;
import cn.mapway.workday.servlets.MapwayApplicationServlet;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 自动配置文档Servlet
 */
@Configuration
@ConditionalOnProperty(prefix = "mapway.application", name = "enabled", havingValue = "true")
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(MapwayApplicationProperties.class)
public class MapwayApplicationConfigure {


    /**
     * The Properties.
     */
    @Autowired
    MapwayApplicationProperties properties;

    /**
     * Instantiates a new Doc auto configure.
     */
    public MapwayApplicationConfigure() {
        System.out.println("mapway application properties initialized");
    }

    /**
     * mapway applicaiton servlet servlet registration bean.
     *
     * @return the servlet registration bean
     */
    @Bean
    @Autowired
    ServletRegistrationBean mapwayApplicationServlet(ApplicationContext appContext) {
        ServletRegistrationBean srb = new ServletRegistrationBean();
        MapwayApplicationServlet servlet = new MapwayApplicationServlet();
        servlet.setAppContext(appContext);
        srb.setServlet(servlet);
        srb.setUrlMappings(Arrays.asList(properties.url));

        Map<String, String> params = new HashMap<String, String>();

        srb.setInitParameters(params);
        srb.setLoadOnStartup(1);
        return srb;
    }

    @Bean
    @Autowired
    ServletRegistrationBean mapwayFrameworkServlet(final Dao dao, final MapwayApplicationProperties properties) {
        ServletRegistrationBean srb = new ServletRegistrationBean();

        WebFrameServlet servlet = new WebFrameServlet() {
            @Override
            public Dao createDao() {
                return dao;
            }

            @Override
            public ClientConfigure getClientConfigure() {
                return properties.getUi();
            }
        };

        srb.setServlet(servlet);
        srb.setUrlMappings(Arrays.asList("/" + WebFrameServlet.DEFAULt_WEB_FRAME_SERVER_PATH));

        Map<String, String> params = new HashMap<String, String>();

        srb.setInitParameters(params);
        srb.setLoadOnStartup(1);
        return srb;
    }

}
