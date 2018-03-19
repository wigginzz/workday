package cn.mapway.workday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

/**
 * workday application.
 */
@SpringBootApplication
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
