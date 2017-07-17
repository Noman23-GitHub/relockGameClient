package inputModule;

import stateData.ClientState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static java.awt.event.KeyEvent.*;

public class InputModuleKeyListener implements KeyListener {

    InputModuleInterface inputModule;

    public InputModuleKeyListener(InputModuleInterface inputModule) {
        this.inputModule = inputModule;
    }

    public void keyTyped(KeyEvent e) {
    }

    byte move = 0;

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_W:
                move = (byte) (move | ClientState.MoveType.MOVE_UP);
                inputModule.sendClientState(move, ClientState.CmdTypeEnum.СMD_NONE, new int[]{0, 0});
                break;
            case VK_A:
                move = (byte) (move | ClientState.MoveType.MOVE_LEFT);
                inputModule.sendClientState(move, ClientState.CmdTypeEnum.СMD_NONE, new int[]{0, 0});
                break;
            case VK_S:
                move = (byte) (move | ClientState.MoveType.MOVE_DOWN);
                inputModule.sendClientState(move, ClientState.CmdTypeEnum.СMD_NONE, new int[]{0, 0});
                break;
            case VK_D:
                move = (byte) (move | ClientState.MoveType.MOVE_RIGHT);
                inputModule.sendClientState(move, ClientState.CmdTypeEnum.СMD_NONE, new int[]{0, 0});
                break;
            case VK_Q:
                inputModule.commandCalled(ClientState.CmdTypeEnum.CMD_SPELL_1);
                break;
            case VK_E:
                inputModule.commandCalled(ClientState.CmdTypeEnum.CMD_SPELL_2);
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_W:
                move = (byte) (move & ~ClientState.MoveType.MOVE_UP);
                inputModule.sendClientState(move, ClientState.CmdTypeEnum.СMD_NONE, new int[]{0, 0});
                break;
            case VK_A:
                move = (byte) (move & ~ClientState.MoveType.MOVE_LEFT);
                inputModule.sendClientState(move, ClientState.CmdTypeEnum.СMD_NONE, new int[]{0, 0});
                break;
            case VK_S:
                move = (byte) (move & ~ClientState.MoveType.MOVE_DOWN);
                inputModule.sendClientState(move, ClientState.CmdTypeEnum.СMD_NONE, new int[]{0, 0});
                break;
            case VK_D:
                move = (byte) (move & ~ClientState.MoveType.MOVE_RIGHT);
                inputModule.sendClientState(move, ClientState.CmdTypeEnum.СMD_NONE, new int[]{0, 0});
                break;
            case VK_Q:
                inputModule.commandWithdrawn();
                break;
            case VK_E:
                inputModule.commandWithdrawn();
                break;
        }
    }
}
