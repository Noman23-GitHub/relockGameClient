package moduleManager;


import networkModule.NetworkModuleConfiguration;
import networkModule.NetworkModuleInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(ModuleManagerConfiguration.class);
        context.register(NetworkModuleConfiguration.class);
        context.refresh();
    }

}


///////////////////////////////////////////////////////////////
        /*AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(ModuleManagerConfiguration.class);

        context.refresh();
        */
///////////////////////////////////////////////////////////////
