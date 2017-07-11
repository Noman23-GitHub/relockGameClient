package stateData;


import java.awt.*;
import java.io.Serializable;
import java.util.List;


// Клиент-сайд гейм-инфо
public class GameState implements Serializable {

    // Сабкласс для описания игроков на поле
    class Player {
        String name;
        Color color;
        int x;
        int y;
    }

    // Перечисление типов игровых объектов
    public enum ObjectTypeEnum {
        TYPE_WALL,
        TYPE_SPEEL
    }

    // Сабкласс для описания объектов на поле
    class GameObject {
        ObjectTypeEnum type;
        int x;
        int y;

    }

    // Листы с объектами
    private List<Player> playerList;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<GameObject> getGameObjectList() {
        return gameObjectList;
    }

    public Exception getServerException() {
        return serverException;
    }

    private List<GameObject> gameObjectList;

    // Эксепшин он сервера, т.е. ошибка на сервере, но переадрессована она клиенту.
    // Перенаправляется в обработчик ошибок, если не null офк.
    Exception serverException;
}
