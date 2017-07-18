package ingameModule;

import inputModule.InputModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@Configuration
@PropertySource("classpath:windowSetting.properties")
public class IngameModuleConfiguration {

    @Resource
    Environment environment;

    public String fps = "1000";

    @Bean
    public IngameModule ingameModule() {
        return new IngameModule();
    }

    @Bean
    public IngameSettings ingameSettings() {
        return new IngameSettings(Integer.parseInt(environment.getProperty("ingame.fps")),
                Integer.parseInt(environment.getProperty("ingame.view.top")),
                Integer.parseInt(environment.getProperty("ingame.view.down")),
                Integer.parseInt(environment.getProperty("ingame.view.left")),
                Integer.parseInt(environment.getProperty("ingame.view.right")),
                Integer.parseInt(environment.getProperty("ingame.field.size.x")),
                Integer.parseInt(environment.getProperty("ingame.field.size.y")));
    }
}