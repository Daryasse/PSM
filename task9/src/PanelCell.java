import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelCell extends JPanel{
    private Color[][] colors;
    private JLabel[][] labels;


    static Color lightBlue = new Color(95, 158, 160);

    private static Cell [][] cells = new Cell[30][30];

    private static int[][] neighbours = {
            {-1, 1}, {0, 1}, {1, 1},
            {-1, 0},         {1, 0},
            {-1, -1}, {0, -1}, {1, -1}};

    PanelCell(int rows, int cols, int cellWidth) {

        colors = new Color[rows][cols];
        labels = new JLabel[rows][cols];

        Listener myListener = new Listener(this);
        this.setFocusable(true);

        Dimension labelPrefSize = new Dimension(cellWidth, cellWidth);

        setLayout(new GridLayout(rows, cols));

        for (int row = 0; row < labels.length; row++) {
            for (int col = 0; col < labels[row].length; col++) {
                JLabel myLabel = new JLabel();
                myLabel.setOpaque(true);
                Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
                myLabel.setBorder(border);

                colors[row][col] = Color.WHITE;

                myLabel.setBackground(colors[row][col]);
                myLabel.addMouseListener(myListener);
                myLabel.setPreferredSize(labelPrefSize);

                add(myLabel);
                labels[row][col] = myLabel;
            }
        }
    }

    private Color[][] getColors() {
        return colors;
    }

    private static boolean isNodeAlive(int x, int y) {
        try {
            return cells[x][y].alive;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    void createNodeGrid() {
        cells = new Cell[colors.length][colors[0].length];
        Color[][] myColors = this.getColors();

        for (int row = 0; row < myColors.length; row++) {
            for (int col = 0; col < myColors[row].length; col++) {
                if (myColors[row][col] == Color.WHITE)
                    cells[row][col] = new Cell(false);
                if (myColors[row][col] == lightBlue)
                    cells[row][col] = new Cell(true);
            }
        }

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int aliveCellCount = 0;
                cells[i][j].toBorn = false;
                for (int [] corner : neighbours) {
                    if (isNodeAlive(i+corner[0],j + corner[1]) )
                        aliveCellCount++;
                }
                    if (Main.right.contains(aliveCellCount) && !cells[i][j].alive)
                        cells[i][j].toBorn = true;

                    if ((Main.left.contains(aliveCellCount)) && cells[i][j].alive)
                        cells[i][j].toBorn = true;

            }
        }


        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].toBorn) {
                    if(i == 0){
                        myColors[cells.length-1][j] = lightBlue;
                        labels[cells.length-1][j].setBackground(lightBlue);
                    }
                    if(j == 0){
                        myColors[i][cells[i].length-1] = lightBlue;
                        labels[i][cells[i].length-1].setBackground(lightBlue);
                    }
                    if(i == cells.length - 1){
                        myColors[0][j] = lightBlue;
                        labels[0][j].setBackground(lightBlue);
                    }
                    if(j == cells[i].length -1){
                        myColors[i][0] = lightBlue;
                        labels[i][0].setBackground(lightBlue);
                    }
                    myColors[i][j] = lightBlue;
                    labels[i][j].setBackground(lightBlue);
                }
                else {
                    myColors[i][j] = Color.WHITE;
                    labels[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    void labelPressed(JLabel label, boolean nodeIsActive) {
        for (int row = 0; row < labels.length; row++) {
            for (int col = 0; col < labels[row].length; col++) {
                if (label == labels[row][col]) {
                    if(nodeIsActive) {
                        colors[row][col] = lightBlue;
                        labels[row][col].setBackground(lightBlue);
                    }
                    else {
                        colors[row][col] = Color.WHITE;
                        labels[row][col].setBackground(Color.WHITE);
                    }
                }
            }
        }
    }
}
