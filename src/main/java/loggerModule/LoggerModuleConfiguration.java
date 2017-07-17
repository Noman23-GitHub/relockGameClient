package loggerModule;


import exceptionModule.ExceptionModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;


@Configuration
@ComponentScan
public class LoggerModuleConfiguration {

    @Resource
    Environment environment;

    @Bean
    public LoggerSettings loggerSettings(){
        String dateFormat = environment.getProperty("logger.dateFormat");
        String fileName = environment.getProperty("logger.fileName");

        return new LoggerSettings(dateFormat, fileName);
    }
    @Bean
    public LoggerModule loggerModule() {
        LoggerModule loggerModule = new LoggerModule();
        return loggerModule;
    }
}