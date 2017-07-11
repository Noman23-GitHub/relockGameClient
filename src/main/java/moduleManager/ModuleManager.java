package moduleManager;


import exceptionModule.ExceptionModuleInterface;
import ingameModule.IngameModuleInterface;
import loggerModule.LoggerModuleInterface;
import networkModule.NetworkModuleInterface;
import stateData.ClientState;
import stateData.GameState;

import java.awt.*;

public class ModuleManager implements ModuleManagerInterface {


    LoggerModuleInterface loggerModule;
    NetworkModuleInterface networkModule;
    IngameModuleInterface ingameModule;
    ExceptionModuleInterface exceptionModule;


    public void transferClientState(ClientState clientState) {
        clientState.AddClientInfo("Noman23", new Color(59, 239, 255));
        networkModule.sendClientState(clientState);
    }

    public void transferGameState(GameState gameState) {
        if (gameState.getServerException() == null) {
            ingameModule.setGameState(gameState);
        } else {
            exceptionModule.setServerException(gameState.getServerException());
        }
    }

    public void transferLocalException(Exception exception) {
        exceptionModule.setLocalException(exception);
    }

    public void transferLogMessage(String message) {
        loggerModule.logMessage(message);
    }
}
