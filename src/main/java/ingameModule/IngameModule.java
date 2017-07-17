package ingameModule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import screenModule.ScreenModuleInterface;
import stateData.GameState;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
import java.util.*;

@Component
public class IngameModule extends JFrame implements IngameModuleInterface {

    @Resource
    ScreenModuleInterface screenModule;

    GameState gs;

    public void setGameState(GameState gameState) {
        gs = gameState;
    }

    @Scheduled(fixedDelay = 1000 / 30)
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
            }
            java.util.List<GameState.GameObject> objects = gs.getGameObjectList();
            for (GameState.GameObject object : objects) {
                if (object.getType() == GameState.GameObject.ObjectTypeEnum.TYPE_WALL) {
                    offgc.setColor(new Color(140, 68, 12));
                    offgc.fillRect(object.getX(), object.getY(), 40, 40);
                }
            }
        }

        screenModule.updateScreen(frame);
    }
}
