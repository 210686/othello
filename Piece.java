import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public abstract class Piece{
    private final Color red = new Color(204, 0, 0);
    BufferedImage bi;
    Graphics2D graphics;
    
    /* Abstract classes */
    public abstract int getOrder();
    
    /* Concrete classes */
    public Piece(){
        /* Create background of circle */
        bi = new BufferedImage(64, 64, BufferedImage.TYPE_3BYTE_BGR);
        graphics = bi.createGraphics();
        graphics.setPaint(new Color(0, 102, 0));
        graphics.fillRect(0, 0, bi.getWidth(), bi.getHeight());
    }
    public BufferedImage drawCircle(){return bi;}
    public BufferedImage drawCircle(Color cFill, Color cOutline){
        graphics.setPaint(cFill); //fill in circle
        if(cFill.equals(red)){graphics.fillOval(24, 24, 16,16);}
        else{graphics.fillOval(8, 8, 48,48);}
        
        graphics.setPaint(cOutline); //outline of circle
        if(cFill.equals(red)){graphics.draw(new Ellipse2D.Double(23, 23, 17, 17));}
        else{graphics.draw(new Ellipse2D.Double(7, 7, 49, 49));}
        
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.dispose(); //dispose
        
        return bi;
    }
}