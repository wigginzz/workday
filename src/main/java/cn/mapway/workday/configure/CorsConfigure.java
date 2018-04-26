package cn.mapway.workday.configure;

import cn.mapway.workday.ui.client.rpc.IWorkdayServer;
import cn.mapway.workday.ui.server.WorkdayServlet;
import org.nutz.lang.Lang;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 跨域调用配置
 * 
 * @author zhangjianshe
 */
@Configuration
public class CorsConfigure extends WebMvcConfigurerAdapter {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins("*")
        .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE");
  }


  private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/META-INF/resources/",
      "classpath:/resources/", "classpath:/static/", "classpath:/public/"};

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
  }

  /**
   * 添加 JSP Controller的连接器，处理用户TOKEn问题
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
   // ControllerInterceptor interceptor = new ControllerInterceptor();
  //  InterceptorRegistration registration = registry.addInterceptor(interceptor);
  //  registration.addPathPatterns("/admin/**");
    super.addInterceptors(registry);
  }

  @Bean
  public ServletRegistrationBean workdayServer () {
    ServletRegistrationBean srb = new ServletRegistrationBean();
    WorkdayServlet servlet =new WorkdayServlet();
    srb.setUrlMappings(Lang.list(WorkdayServlet.DEFAULT_SERVER_PATH));
    srb.setServlet(servlet);
    srb.setLoadOnStartup(1);
    return srb;
  }
}
