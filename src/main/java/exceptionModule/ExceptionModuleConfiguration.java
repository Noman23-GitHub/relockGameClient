package exceptionModule;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class ExceptionModuleConfiguration {


    @Bean
    public ExceptionModule exceptionModule() {
        ExceptionModule exceptionModule = new ExceptionModule();
        return exceptionModule;
    }
}


