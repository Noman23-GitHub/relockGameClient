package exceptionModule;

import moduleManager.ModuleManagerInterface;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ExceptionModule implements ExceptionModuleInterface {
    @Resource
    private ModuleManagerInterface moduleManager;

    public void setServerException(Exception exception) {
        moduleManager.transferLogMessage("ServerException: " + exception.getMessage());
    }

    public void setLocalException(Exception exception) {
        moduleManager.transferLogMessage("LocalException: " + exception.getMessage());
    }
}
