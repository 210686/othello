import java.awt.*;
import javax.swing.*;
public class Main{
    /* private fields */
    private static printBoard pb = new printBoard();
    
    /* non-main methods */
    public static JComponent getFrame(){
        return pb.getBoard();
    }
    
    /* main method */
    public static void main(String[] args){
        System.out.print("\f");
        
        /* Initialize Runnable r */
        Runnable r = new Runnable(){
            @Override
            public void run(){
                /* Initialize JFrame f */
                JFrame f = new JFrame("Othello");
                f.add(getFrame());
                
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