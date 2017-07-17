package networkModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import javax.annotation.Resource;


@Configuration
@ComponentScan
@PropertySource("classpath:networkSettings.properties")
public class NetworkModuleConfiguration {

    @Resource
    Environment environment;

    @Bean
    public NetworkSettings networkSettings()
    {
        String hostName = environment.getProperty("network.hostname");
        int port = Integer.parseInt(environment.getProperty("network.port"));
        return new NetworkSettings(hostName,port);
    }

    @Bean
    public NetworkModule networkModule() {
        return new NetworkModule();
    }

}
