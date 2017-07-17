package inputModule;

import inputModule.InputModule;
import inputModule.InputModuleInterface;
import stateData.ClientState;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Student on 7/17/2017.
 */
public class InputModuleMouseListener implements MouseListener {

    InputModuleInterface inputModule;
    public InputModuleMouseListener(InputModule inputModule) { this.inputModule = inputModule; }

    private ClientState.CmdTypeEnum cmd = ClientState.CmdTypeEnum.СMD_NONE;

    public void commandCalled(ClientState.CmdTypeEnum cmd){this.cmd = cmd;}

    public void commandWithdrawn(){ this.cmd = ClientState.CmdTypeEnum.СMD_NONE; }

    public void mouseClicked(MouseEvent e) {
        if( !cmd.equals(ClientState.CmdTypeEnum.СMD_NONE )){
            int[] mouse_pos = {e.getX(), e.getY()};
            inputModule.sendClientState((byte)0, cmd, mouse_pos);
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
