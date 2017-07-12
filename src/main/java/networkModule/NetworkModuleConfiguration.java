package networkModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@ComponentScan
public class NetworkModuleConfiguration {

    @Bean
    public NetworkModule networkModule() {
        return new NetworkModule();
    }

    @Bean
    public TaskExecutor taskExecutor()
    {
        return new SimpleAsyncTaskExecutor();
    }
}
