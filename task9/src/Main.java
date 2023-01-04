import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class Main {
    private static JFrame frame;
    private static JTextField input;
    private static JTextField color;
    static HashSet<Integer> left = new HashSet<>();
    static HashSet<Integer> right = new HashSet<>();

    private static void createAndShowGui() {
        final int gridSize = 30;
        int cellWidth = 20;

        PanelCell grid = new PanelCell(gridSize, gridSize, cellWidth);

        initFrame();

        frame.setLayout(new BorderLayout());
        frame.add(grid,BorderLayout.NORTH);

        input = new JTextField();
        input.setText("number to survive/ number to born");

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(input,BorderLayout.CENTER);


        input.setPreferredSize(new Dimension(580,30));


        frame.add(p,BorderLayout.CENTER);

        JButton startButton = new JButton();
        startButton.setText("START GAME");
        startButton.setPreferredSize(new Dimension(580,40));



        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(startButton,BorderLayout.CENTER);


        frame.add(p1,BorderLayout.SOUTH);

        Changer thread = new Changer(grid);

        startButton.addActionListener(e -> {
            if (thread.status == -1) {       //start
                if(!getValues())
                    return;

                thread.status = 1;
                thread.execute();

                startButton.setText("END GAME");
            }


            else if (thread.status == 0) {
                thread.status = 1;
                startButton.setText("PAUSE GAME");
            }


            else if (thread.status == 1) {
                System.exit(1);
                thread.status = 0;

                System.out.println("Thread paused");
                startButton.setText("RESUME GAME");
            }
        });



        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static boolean getValues() {
        String [] data = input.getText().replaceAll(" ","").split("/");
        if(data.length != 2) {
            JOptionPane.showMessageDialog(null, "incorrect parameters");
            return false;
        }

        for (char c : data[0].toCharArray()) {
            try{
                left.add(Integer.parseInt(String.valueOf(c)));
            } catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "incorrect parameters");
                return false;
            }
        }

        for (char c : data[1].toCharArray()) {
            try{
                right.add(Integer.parseInt(String.valueOf(c)));
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "incorrect parameters");
                return false;
            }
        }

        return true;
    }

    private static void initFrame() {
        frame = new JFrame();
        frame.setTitle("The game of life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGui);
    }
}
