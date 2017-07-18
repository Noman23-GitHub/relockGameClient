package screenModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class ScreenModule implements ScreenModuleInterface {

    MainScreenJFrame screenFrame;

    @Autowired
    ScreenSettings screenSettings;

    @PostConstruct
    public void init() {
        screenFrame = new MainScreenJFrame(screenSettings);
    }

    public void updateScreen(Image screen) {
        screenFrame.setScreenImage(screen);
        screenFrame.repaint();
    }

    public JFrame getJFrame() {
        return screenFrame;
    }
}
