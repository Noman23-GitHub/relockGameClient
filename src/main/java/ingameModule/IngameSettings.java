package ingameModule;

import org.springframework.stereotype.Component;

@Component
public class IngameSettings {
    public int fps;

    int view_top;
    int view_bot;
    int view_right;
    int view_left;

    int fieldWidth;
    int fieldHeight;

    public String getFps() {
        return Integer.toString(fps);
    }

    public int getView_top() {
        return view_top;
    }

    public int getView_bot() {
        return view_bot;
    }

    public int getView_right() {
        return view_right;
    }

    public int getView_left() {
        return view_left;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public IngameSettings(int fps, int view_top, int view_bot, int view_left, int view_right, int fieldWidth, int fieldHeight) {
        this.fps = fps;
        this.view_top = view_top;
        this.view_bot = view_bot;
        this.view_right = view_right;
        this.view_left = view_left;
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
    }
}
