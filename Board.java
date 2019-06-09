import java.awt.image.BufferedImage;
import java.util.ArrayList;
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

    public boolean check(int order, int i, int j){
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                try{
                    if(x != 0 || y != 0){
                        if(board[i + x][j + y].getOrder() != order){
                            if(checkRecur(order, i + x, j + y, x, y)){ //if has available move
                                return true;
                            }
                        }
                    }
                } catch(Exception e){}
            }
        }
        return false;
    }
    public boolean checkRecur(int order, int i, int j, int direcI, int direcJ){
        try{
            if(board[i][j].getOrder() != order){ //base case
                return true;
            }
            else{
                if(checkRecur(order, i + direcI, j + direcJ, direcI, direcJ)){ //if base case is true
                    return true;
                }
                else{ //else
                    return false;
                }
            }
        } catch(Exception e){ //if reaches ALOoBE or NPE
            return false;
        }
    }

    public BufferedImage getImage(int order, int i, int j){
        try{
            return board[i][j].drawCircle();
        } catch(NullPointerException e){
            if(check(order, i, j)){
                return new Available().drawCircle();
            }
            else{
                return new Null().drawCircle();
            }
        }
    }
}