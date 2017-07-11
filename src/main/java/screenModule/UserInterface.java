package screenModule;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import stateData.GameState;
import stateData.GameState.GameObject;
import stateData.GameState.Player;

import java.util.*;

/**
 * Created by Student on 7/11/2017.
 */
public class UserInterface implements Application{      // еще не готово, но выглядеть будет как то так
    private ArrayList<Arc> players;
    private ArrayList<Rectangle> objects;

    private Pane board;

    public void paint(GameState state){

        ArrayList<Player> playerArrayList  = GameState.getPlayerList();

        players = new ArrayList<Arc>();
        int i = 0;
        for (Player player :playerArrayList) {
            Arc arc = new Arc();
            arc.setCenterX(player.getX());
            arc.setCenterY(player.getY());
            arc.setRadiusX(20);
            arc.setRadiusY(20);
            arc.setLength(270);
            arc.setStartAngle(45+player.getAngle());
            //arc.setStyle()                                цвет еще надо вставить
            players.add(arc);

            board.getChildren().set(i,arc);
            i++;
        }

        ArrayList<GameObject> objectList = GameState.getGameObjectList();

        i = 0;
        for (GameObject object :objectList) {
            Rectangle rectangle = new Rectangle(object.getX(), object.getY(), 20, 20);
            //rectangle.setStyle()                          тоже цвет
            objects.add(rectangle);

            board.getChildren().set(i, rectangle);
            i++;
        }
    }


    public void start(Stage primaryStage) throws Exception {
        final Scene scene = new Scene(board);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
