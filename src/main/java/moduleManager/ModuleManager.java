package moduleManager;

import exceptionModule.ExceptionModuleInterface;
import ingameModule.IngameModuleInterface;
import loggerModule.LoggerModuleInterface;
import networkModule.NetworkModuleInterface;
import stateData.ClientState;
import stateData.GameState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component
public class ModuleManager implements ModuleManagerInterface {

    //@Resource
    //LoggerModuleInterface loggerModule;
    @Resource
    NetworkModuleInterface networkModule;
    @Resource
    IngameModuleInterface ingameModule;
    // @Resource
    //ExceptionModuleInterface exceptionModule;

    @Autowired
    PlayerSettings playerSettings;

    public void transferClientState(ClientState clientState) {
        clientState.AddClientInfo(playerSettings.getName(), playerSettings.getColor());
        networkModule.sendClientState(clientState);
    }

    public void transferGameState(GameState gameState) {
        if (gameState.getServerException() == null) {
            if (ingameModule != null)
                ingameModule.setGameState(gameState);
        } else {
            //exceptionModule.setServerException(gameState.getServerException());
        }
    }

    public void transferLocalException(Exception exception) {
        //exceptionModule.setLocalException(exception);
    }

    public void transferLogMessage(String message) {
        //loggerModule.logMessage(message);
    }
}
