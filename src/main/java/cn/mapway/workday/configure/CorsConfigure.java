package cn.mapway.workday.configure;

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
}
