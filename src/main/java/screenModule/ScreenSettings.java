package screenModule;

import org.springframework.stereotype.Component;

@Component
public class ScreenSettings {

    private int width;
    private int height;

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ScreenSettings(int width, int height) {
        this.width = width;
        this.height = height;
    }
}