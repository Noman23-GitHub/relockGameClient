package ingameModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import screenModule.ScreenModuleInterface;
import screenModule.ScreenSettings;
import stateData.ClientState;
import stateData.GameState;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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


    int view_x = 0;
    int view_y = 0;


    class LavaColor {
        double speed = 60.0 / (50.0);
        double green = 1;
        double greenMax = 60;

        Color getLavaColor() {
            if (green > greenMax || (int) green < 1) speed *= -1;
            green += speed;
            //System.out.println((int)green);
            return new Color(217, (int) green, 0);
        }
    }

    LavaColor lavaColor = new LavaColor();


    @Scheduled(fixedDelay = 1000 / 300)
    public void updateScreen() throws IOException {

        Graphics offgc;
        Image frame = screenModule.getJFrame().createImage(screenSettings.getWidth(), screenSettings.getHeight());
        offgc = frame.getGraphics();
        offgc.setFont(new Font("Century Gothic", Font.BOLD, 18));


        if (gs != null) {

            GameState.Player myPlayer = null;
            java.util.List<GameState.Player> playerList = gs.getPlayerList();


            for (GameState.Player player : playerList) {
                if (player.getPlayerID() == gs.getPlayerID()) {
                    myPlayer = player;
                    break;
                }
            }

            if (view_x + ingameSettings.getView_right() < myPlayer.getX()) {
                if (myPlayer.getX() - ingameSettings.getView_right() > ingameSettings.getFieldWidth() - screenSettings.getWidth()) {
                    view_x = ingameSettings.getFieldWidth() - screenSettings.getWidth();
                } else {
                    view_x = myPlayer.getX() - ingameSettings.getView_right();
                }
            }

            if (view_x + ingameSettings.getView_left() > myPlayer.getX()) {
                if (view_x - ((view_x + ingameSettings.getView_left()) - myPlayer.getX()) < 0) {
                    view_x = 0;
                } else {
                    view_x -= (view_x + ingameSettings.getView_left()) - myPlayer.getX();
                }
            }

            if (view_y + ingameSettings.getView_bot() < myPlayer.getY()) {
                if (myPlayer.getY() - ingameSettings.getView_bot() > ingameSettings.getFieldHeight() - screenSettings.getHeight()) {
                    view_y = ingameSettings.getFieldHeight() - screenSettings.getHeight();
                } else {
                    view_y = myPlayer.getY() - ingameSettings.getView_bot();
                }
            }

            if (view_y + ingameSettings.getView_top() > myPlayer.getY()) {
                if (view_y - ((view_y + ingameSettings.getView_top()) - myPlayer.getY()) < 0) {
                    view_y = 0;
                } else {
                    view_y -= (view_y + ingameSettings.getView_top()) - myPlayer.getY();
                }
            }


            offgc.setColor(lavaColor.getLavaColor());
            offgc.fillRect(0 - view_x, 0 - view_y, 1000, 1000);


            offgc.drawImage(ImageIO.read(ResourceUtils.getFile("classpath:images/frontLava.png")), 0 - view_x, 0 - view_y, screenModule.getJFrame());

            offgc.setColor(new Color(86, 86, 90));
            offgc.fillOval(100 - view_x, 100 - view_y, 800, 800);

            java.util.List<GameState.Player> list = gs.getPlayerList();
            java.util.List<GameState.GameObject> objects = gs.getGameObjectList();
            for (GameState.GameObject object : objects) {
                if (object.getType() == GameState.GameObject.ObjectTypeEnum.TYPE_WALL) {
                    offgc.setColor(new Color(140, 68, 12));
                    offgc.fillRect(object.getX() - view_x, object.getY() - view_y, object.getWidth(), object.getHeigth());
                    offgc.setColor(new Color(68, 255, 0));
                    offgc.fillRect(object.getX() - view_x, object.getY() - view_y, 2, 2);
                }
            }


            for (GameState.Player player : list) {
                offgc.setColor(player.getColor());
                offgc.fillOval(player.getX() - view_x, player.getY() - view_y, 50, 50);
                offgc.setColor(new Color(68, 255, 0));
                offgc.fillRect(player.getX() - view_x, player.getY() - view_y, 2, 2);
                offgc.setColor(new Color(205, 205, 205));
                offgc.drawString(player.getName(), player.getX() + 5 - view_x, player.getY() - 5 - view_y);
            }


            if (selectedSkill != ClientState.CmdTypeEnum.CMD_NONE) {
                offgc.setColor(new Color(205, 205, 205));
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

            offgc.setColor(new Color(205, 205, 205));
            offgc.drawString("My playerID = " + gs.getPlayerID(), 22, 100);
            offgc.drawString("ViewX = " + view_x, 22, 130);
            offgc.drawString("ViewY = " + view_y, 22, 160);
            offgc.drawString("MyX = " + myPlayer.getX(), 22, 190);
            offgc.drawString("MyY = " + myPlayer.getY(), 22, 220);
        }

        screenModule.updateScreen(frame);
    }
}
