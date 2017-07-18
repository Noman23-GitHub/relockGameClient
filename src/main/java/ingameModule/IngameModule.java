package ingameModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import screenModule.ScreenModuleInterface;
import screenModule.ScreenSettings;
import stateData.ClientState;
import stateData.GameState;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;

@Component
public class IngameModule extends JFrame implements IngameModuleInterface {

    @Resource
    ScreenModuleInterface screenModule;

    @Autowired
    IngameSettings ingameSettings;
    @Autowired
    ScreenSettings screenSettings;

    GameState gs;


    public void setSelectedSkill(ClientState.CmdTypeEnum selectedSkill) {
        this.selectedSkill = selectedSkill;
    }

    ClientState.CmdTypeEnum selectedSkill = ClientState.CmdTypeEnum.CMD_NONE;


    public void setGameState(GameState gameState) {
        gs = gameState;
    }

    @Scheduled(fixedDelay = 1000 / 300)
    public void updateScreen() {

        Graphics offgc;
        Image frame = screenModule.getJFrame().createImage(screenSettings.getWidth(), screenSettings.getHeight());
        offgc = frame.getGraphics();


        offgc.setFont(new Font("Century Gothic", Font.BOLD, 18));
        if (gs != null) {
            offgc.setColor(new Color(217, 4, 0));
            offgc.fillRect(0, 0, 1000, 1000);
            offgc.setColor(new Color(97, 4, 0));
            offgc.fillOval(100, 100, 800, 800);

            java.util.List<GameState.Player> list = gs.getPlayerList();
            java.util.List<GameState.GameObject> objects = gs.getGameObjectList();
            for (GameState.GameObject object : objects) {
                if (object.getType() == GameState.GameObject.ObjectTypeEnum.TYPE_WALL) {
                    offgc.setColor(new Color(140, 68, 12));
                    offgc.fillRect(object.getX(), object.getY(), object.getWidth(), object.getHeigth());
                    offgc.setColor(new Color(68, 255, 0));
                    offgc.fillRect(object.getX(), object.getY(), 2, 2);
                }
            }
            for (GameState.Player player : list) {
                offgc.setColor(player.getColor());
                offgc.fillOval(player.getX(), player.getY(), 50, 50);
                offgc.setColor(new Color(68, 255, 0));
                offgc.fillRect(player.getX(), player.getY(), 2, 2);
                offgc.setColor(new Color(205, 205, 205));
                offgc.drawString(player.getName(), player.getX() + 5, player.getY() - 5);
            }


            if (selectedSkill != ClientState.CmdTypeEnum.CMD_NONE) {
                offgc.setColor(new Color(179, 179, 179));
                offgc.fillRect(50, 50, 100, 30);
                offgc.setColor(new Color(0, 0, 0));
            }
            switch (selectedSkill) {

                case CMD_SPELL_1:
                    offgc.drawString("SPEEL 1", 22 + 50, 22 + 50);
                    break;
                case CMD_SPELL_2:
                    offgc.drawString("SPEEL 2", 22 + 50, 22 + 50);
                    break;
            }
        }

        screenModule.updateScreen(frame);
    }
}
