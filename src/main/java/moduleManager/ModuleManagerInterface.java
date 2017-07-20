package moduleManager;

import stateData.ClientState;
import stateData.GameState;


public interface ModuleManagerInterface {
    public void transferClientState(ClientState clientState);
    public void transferGameState(GameState gameState);
    public void transferLocalException(Exception exception);
    public void transferLogMessage(String message);

    public void sendSelectedSkill(ClientState.CmdTypeEnum selectedSkill);

    public int[] getViewXY();
}
