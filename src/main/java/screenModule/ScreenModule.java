package screenModule;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ScreenModule implements ScreenModuleInterface {

    MainScreenJFrame screenFrame;

    public ScreenModule() {
        screenFrame = new MainScreenJFrame();
    }

    public void updateScreen(Image screen) {
        screenFrame.setScreenImage(screen);
        screenFrame.repaint();
    }

    public JFrame getJFrame() {
        return screenFrame;
    }
}
