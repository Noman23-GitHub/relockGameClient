package screenModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScreenModuleConfiguration {
    @Bean
    public ScreenModule screenModule() {
        return new ScreenModule();
    }
}
