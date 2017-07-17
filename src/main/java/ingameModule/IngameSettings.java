package ingameModule;

import org.springframework.stereotype.Component;

@Component
public class IngameSettings {
    public int fps;

    public String getFps() {
        return Integer.toString(fps);
    }

    public IngameSettings(int fps) {
        this.fps = 1000 / fps;
    }
}
