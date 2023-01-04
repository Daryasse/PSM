import javax.swing.*;

public class Changer extends SwingWorker {
    int status = -1;
    private PanelCell grid;
    int sleep = 500;

    Changer(PanelCell mainGrid){
        this.grid = mainGrid;
    }

    @Override
    protected Object doInBackground() throws Exception {
        while (true) {
            grid.createNodeGrid();
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
