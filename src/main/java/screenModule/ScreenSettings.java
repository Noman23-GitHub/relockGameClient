package screenModule;

import org.springframework.stereotype.Component;

@Component
public class ScreenSettings {

    private int width;
    private int heigh;

    public int getWidth(){
        return width;
    }
    public int getHeigh(){
        return heigh;
    }

    public void setWidth(int width){
        this.width = width;
    }
    public void setHeigh(int heigh){
        this.heigh = heigh;
    }

    public ScreenSettings(int width, int heigh){
        this.width = width;
        this.heigh = heigh;
    }
}