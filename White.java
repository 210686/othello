import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public class White extends Piece{
    public White(){}
    
    /* Add functions from Piece here */
    public BufferedImage drawCircle(){
        return super.drawCircle(Color.WHITE, Color.BLACK);
    }
    public int getOrder(){
        return 2;
    }
}