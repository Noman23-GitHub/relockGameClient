package moduleManager;


import ingameModule.IngameModuleConfiguration;
import inputModule.InputModuleConfiguration;
import networkModule.NetworkModuleConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import screenModule.ScreenModuleConfiguration;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(ModuleManagerConfiguration.class);
        context.register(ScreenModuleConfiguration.class);
        context.register(IngameModuleConfiguration.class);
        context.register(InputModuleConfiguration.class);
        context.register(NetworkModuleConfiguration.class);
        //context.register(LoggerModuleConfiguration.class);
        //context.register(ExceptionModuleConfiguration.class);
        context.refresh();

    }
}
