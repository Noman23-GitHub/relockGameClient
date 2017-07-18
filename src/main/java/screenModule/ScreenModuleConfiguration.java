package screenModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@Configuration
@ComponentScan
@PropertySource("classpath:windowSetting.properties")
public class ScreenModuleConfiguration {

    @Resource
    Environment environment;

    @Bean
    public ScreenSettings screenSettings(){

        int width = Integer.parseInt(environment.getProperty("window.width"));
        int height = Integer.parseInt(environment.getProperty("window.height"));

        return new ScreenSettings(width, height);
    }
    @Bean
    public ScreenModule screenModule() {
        return new ScreenModule();
    }
}
