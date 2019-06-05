import java.awt.*;
import javax.swing.*;
public class Main{
    public static void main(String[] args){
        /* Initialize classes */
        printBoard pb = new printBoard();
        printResult pr = new printResult();
        
        /* Initialize Runnable r */
        Runnable r = new Runnable(){
            @Override
            public void run(){
                /* Initialize JFrame f */
                JFrame f = new JFrame("Othello");
                f.add(new JLabel("Hello World"));
                
                /* Add settings to JFrame f */
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                f.setMinimumSize(f.getSize());
                f.setMaximumSize(f.getSize());
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}