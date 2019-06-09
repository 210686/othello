import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public class White implements Piece{
    public White(){}
    
    /* Add functions from Piece here */
    
    public BufferedImage getButtonGraphics(){
        /* Create background of circle */
        BufferedImage bi = new BufferedImage(64, 64, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = bi.createGraphics();
        graphics.setPaint(BG);
        graphics.fillRect(0, 0, bi.getWidth(), bi.getHeight());

        /* Add circle */
        graphics.setPaint(Color.WHITE); //fill in circle
        graphics.fillOval(8, 8, 48,48);
        
        graphics.setPaint(Color.BLACK); //outline of circle
        graphics.draw(new Ellipse2D.Double(7, 7, 49, 49));
        
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.dispose(); //dispose
        
        return bi;
    }
}