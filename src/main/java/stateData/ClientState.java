package stateData;


import java.awt.*;
import java.io.Serializable;


// Сервер-сайд клиент-стейт
public class ClientState implements Serializable {

    //...........................Поля......................................
    private static final long serialVersionUID = 24L;

    // Переменная перемешения
    // Имеет размер байт
    // Пример составления направления:
    // move = MoveType.MOVE_UP | MoveType.MOVE_LEFT;
    private byte move;

    private CmdTypeEnum cmd;

    // Положение мыши m_pos = {x,y}
    private int[] m_pos;

    //  Данные игрока
    String name;    // Имя игрока
    Color color;    // Цвет игрока
    //...................................................................

    //........................Методы......................................
    public ClientState(byte move, CmdTypeEnum cmd, int[] m_pos) {
        this.move = move;
        this.cmd = cmd;
        this.m_pos = m_pos;
    }

    public void AddClientInfo(String name, Color color) {
        this.name = name;
        this.color = color;
    }
    //...............................................................

    //.........................Сабклассы.............................
    // Статичный сабкласс для описания нажатых клавиш перемещения.
    public static class MoveType {
        public final static byte MOVE_NONE = 0;
        public final static byte MOVE_UP = 1;
        public final static byte MOVE_DOWN = 2;
        public final static byte MOVE_LEFT = 4;
        public final static byte MOVE_RIGHT = 8;
    }

    // Команды игрока к серверу
    public enum CmdTypeEnum {
        СMD_NONE,       // Если нажаты только клавиши управления
        CMD_SPELL_1,    // Если запущена способность 1
        CMD_SPELL_2     // Если запушена способность 2
    }
    //...............................................................
}
