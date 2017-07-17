package ingameModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import screenModule.ScreenModuleInterface;
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

    GameState gs;

    public void setGameState(GameState gameState) {
        gs = gameState;
    }

    @Scheduled(fixedDelay = 1000 / 300)
    public void updateScreen() {

        Graphics offgc;
        Image frame = screenModule.getJFrame().createImage(800, 600);
        offgc = frame.getGraphics();


        offgc.setFont(new Font("Century Gothic", Font.BOLD, 18));
        if (gs != null) {
            java.util.List<GameState.Player> list = gs.getPlayerList();
            for (GameState.Player player : list) {
                offgc.setColor(Color.BLACK);
                offgc.drawString(player.getName(), player.getX() + 5, player.getY() - 5);
                offgc.setColor(player.getColor());
                offgc.fillOval(player.getX(), player.getY(), 50, 50);
                offgc.setColor(new Color(68, 255, 0));
                offgc.fillRect(player.getX(), player.getY(), 2, 2);
            }
            java.util.List<GameState.GameObject> objects = gs.getGameObjectList();
            for (GameState.GameObject object : objects) {
                if (object.getType() == GameState.GameObject.ObjectTypeEnum.TYPE_WALL) {
                    offgc.setColor(new Color(140, 68, 12));
                    offgc.fillRect(object.getX(), object.getY(), object.getWidth(), object.getHeigth());
                    offgc.setColor(new Color(68, 255, 0));
                    offgc.fillRect(object.getX(), object.getY(), 2, 2);
                }
            }
        }

        screenModule.updateScreen(frame);
    }
}
