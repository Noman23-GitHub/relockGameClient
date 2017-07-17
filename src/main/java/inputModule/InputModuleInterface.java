package inputModule;

import stateData.ClientState;

/**
 * Created by Student on 14-Jul-17.
 */
public interface InputModuleInterface {
    public void sendClientState(byte move, ClientState.CmdTypeEnum cmd, int m_pos[]);
    public void commandCalled(ClientState.CmdTypeEnum cmd);
    public void commandWithdrawn();
}
