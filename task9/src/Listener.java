import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Listener  extends MouseAdapter {
    private PanelCell grid;
    private boolean isMousePressed = false;
    private boolean nodeActive;

    Listener(PanelCell grid) {
        this.grid = grid;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isMousePressed = true;
        if (e.getButton() == MouseEvent.BUTTON1)
            grid.labelPressed((JLabel) e.getSource(), true);
        else if (e.getButton() == MouseEvent.BUTTON3)
            grid.labelPressed((JLabel) e.getSource(), false);
        else
            e.consume();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isMousePressed = false;
        nodeActive = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (isMousePressed && nodeActive)
            grid.labelPressed((JLabel)e.getSource(), nodeActive);
    }
}
