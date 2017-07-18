package stateData;


import java.awt.*;
import java.io.Serializable;
import java.util.List;


// Сервер-сайд гейм-стейт
public class GameState implements Serializable {

    //....................................Поля............................................
    private static final long serialVersionUID = 23L;

    private int playerID;
    // Листы с объектами
    private List<Player> playerList;
    private List<GameObject> gameObjectList;

    // Эксепшин он сервера, т.е. ошибка на сервере, но переадрессована она клиенту.
    // Перенаправляется в обработчик ошибок, если не null офк.
    Exception serverException;
    //....................................................................................

    //.....................................Методы.........................................
    public int getPlayerID() {
        return playerID;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<GameObject> getGameObjectList() {
        return gameObjectList;
    }

    public Exception getServerException() {
        return serverException;
    }
    //....................................................................................

    //....................................Сабклассы.......................................
    public static class Player implements Serializable {

        private static final long serialVersionUID = 25L;

        int playerID;
        String name;
        private Color color;
        private int angle;
        private int x;
        private int y;


        public int getPlayerID() {
            return playerID;
        }

        public String getName() {
            return name;
        }

        public Color getColor() {
            return color;
        }

        public int getAngle() {
            return angle;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    // Сабкласс для описания объектов на поле
    public static class GameObject implements Serializable {

        private static final long serialVersionUID = 26L;

        // Перечисление типов игровых объектов
        public enum ObjectTypeEnum {
            TYPE_WALL,
            TYPE_SPEEL
        }

        private ObjectTypeEnum type;
        private int x;
        private int y;
        private int width;
        private int heigth;



        public ObjectTypeEnum getType() {
            return type;
        }

        public int getWidth() {
            return width;
        }

        public int getHeigth() {
            return heigth;
        }
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }
    //....................................................................................
}
