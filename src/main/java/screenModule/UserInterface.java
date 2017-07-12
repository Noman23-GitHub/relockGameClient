package screenModule;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import stateData.ClientState;
import stateData.GameState;

public class UserInterface extends Application{


    final int up = 1, down=2, left=3, right=4;
    GraphicsContext gc;
    Canvas canvas;
    Thread game;
    private GameState gameState;

    boolean lost = false;


    public void start(Stage primaryStage){

        canvas.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent e) {
                KeyCode key=e.getCode();
                if(key.equals(KeyCode.UP))createState(up, null);
                if(key.equals(KeyCode.DOWN))createState(down, null);
                if(key.equals(KeyCode.LEFT))createState(left, null);
                if(key.equals(KeyCode.RIGHT))createState(right, null);
            }
        });

        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                double[] coord = {event.getX(), event.getY()};
                createState(0, coord);
            }
        });
    }

    public void startGame(){
        game = new Thread(new Runnable() {
            public void run() {

                while(true){
                    if(gameState != null){
                        draw(gc);
                        gameState = null;
                    }
                    try {
                        Thread.sleep(50);
                    }catch(InterruptedException ie){
                        System.out.println(ie.getMessage());
                        startGame();
                    }
                }
            }
        });
        game.start();
    }

    public static void draw(GraphicsContext gc){

    }

    private ClientState createState(int keyDirection,double[] mouseCoordinates){

        return null;
    }
    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }
}
