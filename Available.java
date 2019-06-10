import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public class Available extends Piece{
    public Available(){}
    
    /* Add functions from Piece here */
    public BufferedImage drawCircle(){
        return super.drawCircle(new Color(204, 0, 0), Color.BLACK);
    }
    public int getOrder(){
        return 0;
    }
}