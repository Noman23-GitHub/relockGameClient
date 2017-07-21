package inputModule;

import moduleManager.ModuleManagerInterface;
import org.springframework.stereotype.Component;
import screenModule.ScreenModuleInterface;
import stateData.ClientState;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class InputModule implements InputModuleInterface {

    @Resource
    ModuleManagerInterface moduleManager;

    @Resource
    ScreenModuleInterface screenModule;

    InputModuleMouseListener mouseListener;


    ClientState.CmdTypeEnum selectedSkill = ClientState.CmdTypeEnum.CMD_NONE;

    byte move = 0;

    public ClientState.CmdTypeEnum getSelectedSkill() {
        return selectedSkill;
    }

    @PostConstruct
    public void init() {
        moduleManager.transferClientState(new ClientState((byte) 0, ClientState.CmdTypeEnum.CMD_NONE, new int[]{0, 0}));
        screenModule.getJFrame().addKeyListener(new InputModuleKeyListener(this));
        screenModule.getJFrame().addMouseListener(mouseListener = new InputModuleMouseListener(this));
    }

    public void sendClientState(byte move, ClientState.CmdTypeEnum cmd, int m_pos[]) {
        this.move = move;
        moduleManager.transferClientState(new ClientState(move, cmd, m_pos));
    }

    public void sendMouseClick(int m_pos[]) {

        int viewXY[] = moduleManager.getViewXY();

        if (selectedSkill != ClientState.CmdTypeEnum.CMD_NONE) {
            System.out.println("Casted");
            moduleManager.transferClientState(new ClientState(move, selectedSkill, new int[]{m_pos[0] + viewXY[0], m_pos[1] + viewXY[1]}));
            selectKeyPressed(ClientState.CmdTypeEnum.CMD_NONE);
        }
    }

    public void selectKeyPressed(ClientState.CmdTypeEnum selectedSkill) {
        this.selectedSkill = selectedSkill;
        moduleManager.sendSelectedSkill(selectedSkill);
    }
}
