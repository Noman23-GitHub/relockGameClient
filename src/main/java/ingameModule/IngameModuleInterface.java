package ingameModule;

import stateData.ClientState;
import stateData.GameState;

public interface IngameModuleInterface {
    public void setGameState(GameState gameState);

    public void setSelectedSkill(ClientState.CmdTypeEnum selectedSkill);
}
