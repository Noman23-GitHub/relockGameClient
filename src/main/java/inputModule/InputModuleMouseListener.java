package inputModule;

import inputModule.InputModule;
import inputModule.InputModuleInterface;
import stateData.ClientState;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Student on 7/17/2017.
 */
public class InputModuleMouseListener implements MouseListener {

    InputModuleInterface inputModule;
    public InputModuleMouseListener(InputModule inputModule) { this.inputModule = inputModule; }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            inputModule.sendMouseClick(new int[]{e.getX(), e.getY()});
            System.out.println("Clicked");
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
