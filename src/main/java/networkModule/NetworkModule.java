package networkModule;

import moduleManager.ModuleManagerInterface;
import org.springframework.stereotype.Component;
import stateData.ClientState;

import javax.annotation.Resource;

@Component
public class NetworkModule implements NetworkModuleInterface {

    @Resource
    ModuleManagerInterface moduleManager;

    public void sendClientState(ClientState clientState) {

    }


}
