package networkModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.annotation.Resource;
import java.net.Socket;

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

    @Bean
    public Socket socket()
    {
        return  new Socket();
    }

    @Bean
    public TaskExecutor taskExecutor()
    {
        return new SimpleAsyncTaskExecutor();
    }
}
