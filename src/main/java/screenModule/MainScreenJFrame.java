package screenModule;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;


public class MainScreenJFrame extends JFrame {

    Graphics2D drawer;
    Image screenImage;

    ScreenSettings screenSettings;

    public void setScreenImage(Image screenImage) {
        this.screenImage = screenImage;
    }

    public MainScreenJFrame(ScreenSettings screenSettings) {
        super("Game");

        setSize(screenSettings.getWidth(), screenSettings.getHeight());
        setVisible(true);
    }

    public void paint(Graphics g) {
        drawer = (Graphics2D) g;
        drawer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        drawer.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (screenImage != null)
            drawer.drawImage(screenImage, 0, 0, this);
    }
}
