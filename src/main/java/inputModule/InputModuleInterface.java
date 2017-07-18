package inputModule;

import stateData.ClientState;

/**
 * Created by Student on 14-Jul-17.
 */
public interface InputModuleInterface {
    public void sendClientState(byte move, ClientState.CmdTypeEnum cmd, int m_pos[]);

    public void selectKeyPressed(ClientState.CmdTypeEnum selectedKey);

    public ClientState.CmdTypeEnum getSelectedSkill();

    public void sendMouseClick(int m_pos[]);
}
