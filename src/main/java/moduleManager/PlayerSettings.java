package moduleManager;

import java.awt.*;


public class PlayerSettings {
    private String name;
    private Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PlayerSettings(String name, Color color) {
        this.name = name;
        this.color = color;
    }
}
