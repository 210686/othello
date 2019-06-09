import java.awt.image.BufferedImage;
public class Board{
    /* Add private fields */
    private Piece[][] board = new Piece[8][8];
    
    /* Initialize constructor */
    public Board(){
        /* Set initial board */
        board[3][3] = new Black();
        board[3][4] = new White();
        board[4][3] = new White();
        board[4][4] = new Black();
    }
    public BufferedImage getImage(int i, int j){
        try{
            return board[i][j].getButtonGraphics();
        } catch(NullPointerException e){
            return new Null().getButtonGraphics();
        }
    }
}