package inputModule;

import moduleManager.ModuleManagerInterface;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import screenModule.ScreenModuleInterface;
import stateData.ClientState;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;

@Component
public class InputModule implements InputModuleInterface {

    @Resource
    ModuleManagerInterface moduleManager;

    @Resource
    ScreenModuleInterface screenModule;

    @PostConstruct
    public void init() {
        moduleManager.transferClientState(new ClientState((byte) 0, ClientState.CmdTypeEnum.СMD_NONE, new int[]{0, 0}));
        screenModule.getJFrame().addKeyListener(new InputModuleKeyListner(this));
    }

    public void sendClientState(byte move, ClientState.CmdTypeEnum cmd, int m_pos[]) {
        moduleManager.transferClientState(new ClientState(move, cmd, m_pos));
    }
}
