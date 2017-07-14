package ingameModule;

import inputModule.InputModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IngameModuleConfiguration {
    @Bean
    public IngameModule ingameModule() {
        return new IngameModule();
    }
}
