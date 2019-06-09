import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public class Null implements Piece{
    public Null(){}
    
    /* Add functions from Piece here */
    
    public BufferedImage getButtonGraphics(){
        /* Create background of button */
        BufferedImage bi = new BufferedImage(64, 64, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = bi.createGraphics();
        graphics.setPaint(BG);
        graphics.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        graphics.dispose(); //dispose
        
        return bi;
    }
}