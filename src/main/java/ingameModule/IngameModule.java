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
<<<<<<< HEAD
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
=======
import java.io.IOException;
>>>>>>> upstream/master

@Component
public class IngameModule extends JFrame implements IngameModuleInterface {

    @Resource
    ScreenModuleInterface screenModule;

    @Autowired
    IngameSettings ingameSettings;
    @Autowired
    ScreenSettings screenSettings;

    GameState gs;
    GameState previousGs;
    List<GameState.Player> playerList;
    List<GameState.Player> prPlayerList;
    PseudoPlayer[][] interList;
    int render = 0;

    private class PseudoPlayer{
        int x, y, angle;
        Color color;
        String name;

        PseudoPlayer(int x, int y, int angle, String name, Color color){this.angle = angle; this.x = x; this.y = y; this.name = name; this.color = color; }
    }


    public void setSelectedSkill(ClientState.CmdTypeEnum selectedSkill) {
        this.selectedSkill = selectedSkill;
    }

    ClientState.CmdTypeEnum selectedSkill = ClientState.CmdTypeEnum.CMD_NONE;


    public void setGameState(GameState gameState) {
        previousGs = gs;
        gs = gameState;


        playerList = gs.getPlayerList();
        prPlayerList = previousGs.getPlayerList();
        Map<Integer, GameState.Player> players = playerList.stream().collect(Collectors.toMap(GameState.Player::getPlayerID, Function.identity()));
        Map<Integer, GameState.Player> prevPlayers = prPlayerList.stream().collect(Collectors.toMap(GameState.Player::getPlayerID, Function.identity()));
        render = 0;
        interList = new PseudoPlayer[5][gs.getPlayerList().size()];
        int j = 0;
        //for (GameState.Player player: playerList) {

        for (Map.Entry<Integer, GameState.Player> player : players.entrySet()) {

            int deltaX;
            int deltaY;
            int deltaAngle;
            int x, y, angle;
            deltaX = (x = player.getValue().getX() - prevPlayers.get(player.getKey()).getX())/7;
            deltaY = (y = player.getValue().getY() - prevPlayers.get(player.getKey()).getY())/7;
            deltaAngle = ( angle = player.getValue().getAngle() - prevPlayers.get(player.getKey()).getAngle())/7;

            interList[4][j] = new PseudoPlayer(x -= deltaX, y -= deltaY, angle -= deltaAngle , player.getValue().getName(), player.getValue().getColor());
            interList[3][j] = new PseudoPlayer(x -= deltaX, y -= deltaY, angle -= deltaAngle , player.getValue().getName(), player.getValue().getColor());
            interList[2][j] = new PseudoPlayer(x -= deltaX, y -= deltaY,angle -= deltaAngle , player.getValue().getName(), player.getValue().getColor());
            interList[1][j] = new PseudoPlayer(x -= deltaX, y -= deltaY, angle -= deltaAngle , player.getValue().getName(), player.getValue().getColor());
            interList[0][j] = new PseudoPlayer(x -= deltaX, y -= deltaY, angle -= deltaAngle , player.getValue().getName(), player.getValue().getColor());
        }

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


<<<<<<< HEAD

        offgc.setFont(new Font("Century Gothic", Font.BOLD, 18));

=======
>>>>>>> upstream/master
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


            java.util.List<GameState.GameObject> objects = gs.getGameObjectList();
            for (GameState.GameObject object : objects) {
                if (object.getType() == GameState.GameObject.ObjectTypeEnum.TYPE_WALL) {
                    offgc.setColor(new Color(140, 68, 12));
                    offgc.fillRect(object.getX() - view_x, object.getY() - view_y, object.getWidth(), object.getHeigth());
                    offgc.setColor(new Color(68, 255, 0));
                    offgc.fillRect(object.getX() - view_x, object.getY() - view_y, 2, 2);
                }
            }
<<<<<<< HEAD
=======


            for (GameState.Player player : list) {
                offgc.setColor(player.getColor());
                offgc.fillOval(player.getX() - view_x, player.getY() - view_y, 50, 50);
                offgc.setColor(new Color(68, 255, 0));
                offgc.fillRect(player.getX() - view_x, player.getY() - view_y, 2, 2);
                offgc.setColor(new Color(205, 205, 205));
                offgc.drawString(player.getName(), player.getX() + 5 - view_x, player.getY() - 5 - view_y);
            }


>>>>>>> upstream/master
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
<<<<<<< HEAD
            if (gs != null && previousGs != null) {


                if (render == 0) {
                    for (GameState.Player player : prPlayerList) {
                        offgc.setColor(player.getColor());
                        offgc.fillOval(player.getX(), player.getY(), 50, 50);
                        offgc.setColor(new Color(68, 255, 0));
                        offgc.fillRect(player.getX(), player.getY(), 2, 2);
                        offgc.setColor(new Color(205, 205, 205));
                        offgc.drawString(player.getName(), player.getX() + 5, player.getY() - 5);
                    }
                }
                else if (render == 6) {
                    for (GameState.Player player : prPlayerList) {
                        offgc.setColor(player.getColor());
                        offgc.fillOval(player.getX(), player.getY(), 50, 50);
                        offgc.setColor(new Color(68, 255, 0));
                        offgc.fillRect(player.getX(), player.getY(), 2, 2);
                        offgc.setColor(new Color(205, 205, 205));
                        offgc.drawString(player.getName(), player.getX() + 5, player.getY() - 5);
                    }
                }
                else
                    for (PseudoPlayer player : interList[render - 1]) {
                        offgc.setColor(player.color);
                        offgc.fillOval(player.x, player.y, 50, 50);
                        offgc.setColor(new Color(68, 255, 0));
                        offgc.fillRect(player.x, player.y, 2, 2);
                        offgc.setColor(new Color(205, 205, 205));
                        offgc.drawString(player.name, player.x + 5, player.y - 5);
                    }
                    render++;
            }
=======

            offgc.setColor(new Color(205, 205, 205));
            offgc.drawString("My playerID = " + gs.getPlayerID(), 22, 100);
            offgc.drawString("ViewX = " + view_x, 22, 130);
            offgc.drawString("ViewY = " + view_y, 22, 160);
            offgc.drawString("MyX = " + myPlayer.getX(), 22, 190);
            offgc.drawString("MyY = " + myPlayer.getY(), 22, 220);
>>>>>>> upstream/master
        }
        screenModule.updateScreen(frame);
    }
}
