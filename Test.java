import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
public class Test{
    public static void main(String[] args){
        Runnable r = new Runnable(){
            @Override
            public void run(){
                JFrame f = new JFrame("Test");
                f.add(drawCircle());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.pack();
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
    public static JPanel drawCircle(){
        JPanel p = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g;
                    Shape circle = new Ellipse2D.Double(16, 16, 64, 64);
                    g2.draw(circle);
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                }
            };
        return p;
    }
}