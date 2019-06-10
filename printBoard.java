import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.lang.Math;
public class printBoard{
    private JButton[][] boardSquares = new JButton[8][8];
    private JPanel board;
    private JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JToolBar tools = new JToolBar();
    private JButton b1, b2, b3;
    private Board newBoard = new Board();
    private int order = 1;
    private boolean gameover = false;
    private ArrayList<Result> resArr = new ArrayList<Result>();
    
    /* constructor */
    public printBoard(){
        update();
    }

    public void update(){
        gui.removeAll();
        tools.removeAll();
        newBoard.Available(order);
        printHead();
    }

    public void printHead(){
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        
        int b = newBoard.countBlack();
        int w = newBoard.countWhite();
        
        /* Function of b1 */
        tools.add(b1 = new JButton("New"));
        b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent a){
                    newBoard = new Board();
                    order = 1;
                    gameover = false;
                    update();
                }
            });
        tools.addSeparator();
        
        /* Function of b2 */
        tools.add(b2 = new JButton("Result"));
        b2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent a){
                    new printResult(resArr);
                }
            });
        tools.addSeparator();
        
        /* Function of b3 */
        tools.add(b3 = new JButton("Random"));
        b3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent a){
                    int overflow = 0;
                    while(!gameover && overflow < 60){
                        int i = (int)(Math.random() * 8);
                        int j = (int)(Math.random() * 8);
                        if(newBoard.move(order, i, j)){
                            update();
                            break;
                        }
                        overflow++;
                    }
                }
            });
        tools.addSeparator();
        
        if(b == 0 || w == 0 || b + w == 64){
            tools.add(new JLabel("Game Over"));
            gameover = true;
            resArr.add(new Result(b, w));
        }
        else if(order == 1){
            tools.add(new JLabel("Black's Turn"));
        }
        else{
            tools.add(new JLabel("White's Turn"));
        }
        order = (order++) % 2 + 1;
        if(newBoard.countAv() == 0 && !gameover){
            update();
        }

        tools.addSeparator();
        tools.add(new JLabel("Black: " + String.valueOf(b)));
        tools.add(new JLabel(" White: " + String.valueOf(w)));
        
        if(!gameover){
            printMain();
        }
    }

    public void printMain(){
        board = new JPanel(new GridLayout(0, 9));
        board.setBorder(new LineBorder(Color.BLACK));

        /* Action for the board Buttons */
        ActionListener listener = new ActionListener(){
                public void actionPerformed(ActionEvent a){
                    Object source = a.getSource();
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) { 
                            if (source == boardSquares[i][j]){
                                if(newBoard.move(order, i, j)){
                                    update();
                                }
                            }
                        }
                    }
                }
            };

        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);

                /* Add graphics here */
                b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                ImageIcon icon = new ImageIcon(newBoard.getImage(order, i, j));
                b.setIcon(icon);
                b.setBackground(Color.BLACK);
                b.setOpaque(true);

                boardSquares[i][j] = b;
            }
        }

        board.add(new JLabel(""));
        for (int i = 0; i < 8; i++) {
            board.add(new JLabel(String.valueOf(i + 1), SwingConstants.CENTER));
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                    board.add(new JLabel(String.valueOf(i + 1), SwingConstants.CENTER));

                    default:
                    boardSquares[i][j].addActionListener(listener);
                    board.add(boardSquares[i][j]);
                }
            }
        }

        gui.add(board);
    }

    /* return  getters */
    public JComponent getBoard(){
        return gui;
    }
}