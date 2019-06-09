import java.awt.image.BufferedImage;
public class Board{
    /* Add private fields */
    private Piece[][] board = new Piece[8][8];
    private int hasMove = 0;
    /* Initialize constructor */
    public Board(){
        /* Set initial board */
        board[3][3] = new Black();
        board[3][4] = new White();
        board[4][3] = new White();
        board[4][4] = new Black();
    }

    public boolean check(int order, int i, int j){
        hasMove = 0;
        
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                try{
                    if(x != 0 || y != 0){
                        if(board[i + x][j + y].getOrder() != order //if has a different color
                        && board[i + x][j + y].getOrder() > 0){//not null
                            if(checkRecur(order, i + x, j + y, x, y)){//if has available move
                                if(order == 1){board[i][j] = new Black();}
                                else{board[i][j] = new White();}
                                hasMove++;
                            }
                        }
                    }
                } catch(Exception e){}
            }
        }

        return hasMove > 0;
    }
    public int hasMove(){return hasMove;}
    public boolean checkRecur(int order, int i, int j, int direcI, int direcJ){
        try{
            if(board[i][j].getOrder() > 0){ //is black or white
                if(board[i][j].getOrder() == order){ //base case
                    return true;
                }
                else{
                    if(checkRecur(order, i + direcI, j + direcJ, direcI, direcJ)){ //if base case is true
                        if(order == 1){board[i][j] = new Black();}
                        else{board[i][j] = new White();}
                        return true;
                    }
                    else{ //else
                        return false;
                    }
                }
            }
            return false;
        } catch(Exception e){return false;}
    }

    public BufferedImage getImage(int order, int i, int j){
        try{
            return board[i][j].drawCircle();
        } catch(NullPointerException e){
            return new Null().drawCircle();
        }
    }
    public int countBlack(){
        int numBlack = 0;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                try{
                    if(board[x][y].getOrder() == 1){numBlack++;}
                } catch(NullPointerException e){}
            }
        }
        return numBlack;
    }
    public int countWhite(){
        int numWhite = 0;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                try{
                    if(board[x][y].getOrder() == 2){numWhite++;}
                } catch(NullPointerException e){}
            }
        }
        return numWhite;
    }
}