package cn.mapway.workday;

import cn.ennwifi.webframe.configure.SystemPropertyDefaultsInitializer;
import cn.mapway.workday.configure.DbConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

/**
 * workday application.
 */
@SpringBootApplication
@EnableConfigurationProperties({DbConfigure.class})
public class Application {
    private static Logger logger = Logger.getLogger("Workday.link application");

    /**
     * @param args
     */
    public static void main(String[] args) {

        SystemPropertyDefaultsInitializer initializer = new SystemPropertyDefaultsInitializer();
        initializer.initialize();

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            logger.info("Spring Boot 使用profile为:" + profile);
        }
    }
}
