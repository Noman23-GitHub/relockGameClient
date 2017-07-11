package networkModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class NetworkModuleConfiguration {

    @Bean
    public NetworkModule networkModule() {
        return new NetworkModule();
    }
}
