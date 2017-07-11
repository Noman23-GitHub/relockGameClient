package moduleManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.awt.*;

@Configuration
@PropertySource("classpath:playerSettings.properties")
public class ModuleManagerConfiguration {

    @Resource
    Environment environment;

    @Bean
    public PlayerSettings playerSettings() {

        Color color = new Color(Integer.parseInt(environment.getProperty("player.color.red")),
                Integer.parseInt(environment.getProperty("player.color.green")),
                Integer.parseInt(environment.getProperty("player.color.blue")));

        PlayerSettings playerSettings = new PlayerSettings(environment.getProperty("player.name"), color);
        return playerSettings;
    }

    @Bean
    public ModuleManager moduleManager() {
        ModuleManager moduleManager = new ModuleManager();
        return moduleManager;
    }
}
