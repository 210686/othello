import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class Board{
    /* Add private fields */
    private Piece[][] board = new Piece[8][8];
    
    /* Initialize constructor */
    public Board(){
        /* Set initial board */
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                board[x][y] = new Null();
            }
        }
        board[3][3] = new Black();
        board[3][4] = new White();
        board[4][3] = new White();
        board[4][4] = new Black();
    }

    public void Available(int order){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(board[x][y].getOrder() == 0){board[x][y] = new Null();}
                if(board[x][y].getOrder() == -1 && check(order, x, y)){
                    board[x][y] = new Available();
                }
            }
        }
    }

    public boolean check(int order, int i, int j){
        boolean hasMove = false;
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                try{
                    if(board[i + x][j + y].getOrder() != order //if has a different color
                    && board[i + x][j + y].getOrder() > 0){//has color
                        if(checkRecur(order, i + x, j + y, x, y)){//if has available move
                            hasMove = true;
                        }
                    }
                } catch(ArrayIndexOutOfBoundsException e){}
            }
        }
        return hasMove;
    }

    public boolean checkRecur(int order, int i, int j, int direcI, int direcJ){
        try{
            if(board[i][j].getOrder() > 0){ //is black or white
                if(board[i][j].getOrder() == order){ //base case
                    return true;
                }
                else{
                    //if base case is true
                    if(checkRecur(order, i + direcI, j + direcJ, direcI, direcJ)){ 
                        return true;
                    }
                    else{ //else
                        return false;
                    }
                }
            }
        } catch(ArrayIndexOutOfBoundsException e){}
        return false;
    }

    public BufferedImage getImage(int order, int i, int j){
        return board[i][j].drawCircle();
    }

    public int countAv(){
        int numAvailable = 0;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(board[x][y].getOrder() == 0){numAvailable++;}
            }
        }
        return numAvailable;
    }

    public int countBlack(){
        int numBlack = 0;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(board[x][y].getOrder() == 1){numBlack++;}
            }
        }
        return numBlack;
    }

    public int countWhite(){
        int numWhite = 0;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(board[x][y].getOrder() == 2){numWhite++;}
            }
        }
        return numWhite;
    }

    public boolean move(int order, int i, int j){
        if(board[i][j].getOrder() == 0){
            for(int x = -1; x <= 1; x++){
                for(int y = -1; y <= 1; y++){
                    try{
                        if(board[i + x][j + y].getOrder() == order //if has a different color
                        && board[i + x][j + y].getOrder() > 0){//has color
                            if(changeRecur(order, i + x, j + y, x, y)){//if has available move
                                if(order == 1){board[i][j] = new White();}
                                else{board[i][j] = new Black();}
                            }
                        }
                    } catch(Exception e){}
                }
            }
            return true;
        }
        return false;
    }

    public boolean changeRecur(int order, int i, int j, int direcI, int direcJ){
        try{
            if(board[i][j].getOrder() > 0){ //is black or white
                if(board[i][j].getOrder() != order){ //base case
                    return true;
                }
                else{
                    //if base case is true
                    if(changeRecur(order, i + direcI, j + direcJ, direcI, direcJ)){ 
                        if(order == 1){board[i][j] = new White();}
                        else{board[i][j] = new Black();}
                        return true;
                    }
                    else{ //else
                        return false;
                    }
                }
            }
        } catch(Exception e){}
        return false;
    }
}