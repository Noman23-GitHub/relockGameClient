package inputModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InputModuleConfiguration {
    @Bean
    public InputModule inputModule() {
        return new InputModule();
    }
}
