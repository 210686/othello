import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public class Black extends Piece{
    public Black(){}
    
    public BufferedImage drawCircle(){
        return super.drawCircle(Color.BLACK, Color.WHITE);
    }
    public int getOrder(){
        return 1;
    }
}