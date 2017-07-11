package moduleManager;


import networkModule.NetworkModuleConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(ModuleManagerConfiguration.class);
        context.register(NetworkModuleConfiguration.class);
        context.refresh();
    }
}
