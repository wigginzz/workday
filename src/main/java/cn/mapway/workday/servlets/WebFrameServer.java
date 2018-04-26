package cn.mapway.workday.servlets;

import cn.ennwifi.webframe.ui.server.servlet.WebFrameServlet;
import cn.ennwifi.webframe.ui.shared.module.ClientConfigure;
import cn.mapway.workday.configure.UIProperties;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * UI Server 初始化.
 *
 * @author zhangjianshe
 */
@Component
public class WebFrameServer extends ServletRegistrationBean {

    @Autowired
    Dao dao;

    @Resource
    UIProperties uiProperties;

    public WebFrameServer() {

        // servlet
        WebFrameServlet servlet = new WebFrameServlet() {
            @Override
            public Dao createDao() {
                return dao;
            }

            @Override
            public ClientConfigure getClientConfigure() {
                return uiProperties;
            }
        };
        // servlet parameters
        Map<String, String> params = getParameters();

        setServlet(servlet);
        addUrlMappings("/" + WebFrameServlet.DEFAULt_WEB_FRAME_SERVER_PATH + "/*");
        setInitParameters(params);
        setLoadOnStartup(1);
    }

    /**
     * 生成文档的配置信息.
     *
     * @return 配置信息
     */
    private Map<String, String> getParameters() {
        Map<String, String> params = new HashMap<String, String>();

        return params;
    }

}
