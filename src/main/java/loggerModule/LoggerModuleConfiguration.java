package loggerModule;


import exceptionModule.ExceptionModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class LoggerModuleConfiguration {

    @Bean
    public LoggerModule loggerModule() {
        LoggerModule loggerModule = new LoggerModule();
        return loggerModule;
    }
}