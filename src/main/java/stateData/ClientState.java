package stateData;


import java.awt.*;
import java.io.Serializable;


// Клиент-сайд слиент-инфо
public class ClientState implements Serializable {

    // Статичный сабкласс для описания нажатых клавиш перемещения.
    static class MoveType {
        final static byte MOVE_NONE = 0;
        final static byte MOVE_UP = 1;
        final static byte MOVE_DOWN = 2;
        final static byte MOVE_LEFT = 4;
        final static byte MOVE_RIGHT = 8;
    }

    // Переменная перемешения
    // Имеет размер байт
    // Пример составления направления:
    // move = MoveType.MOVE_UP | MoveType.MOVE_LEFT;
    private byte move;


    // Команды игрока к серверу
    public static enum CmdTypeEnum {
        СMD_NONE,       // Если нажаты только клавиши управления
        CMD_SPELL_1,    // Если запущена способность 1
        CMD_SPELL_2     // Если запушена способность 2
    }

    ;
    private CmdTypeEnum cmd;

    // Положение мыши m_pos = {x,y}
    private int[] m_pos;

    //  Данные игрока
    String name;    // Имя игрока
    Color color;    // Цвет игрока

    public ClientState(byte move, CmdTypeEnum cmd, int[] m_pos) {
        this.move = move;
        this.cmd = cmd;
        this.m_pos = m_pos;
    }

    public void AddClientInfo(String name, Color color) {
        this.name = name;
        this.color = color;
    }
}
