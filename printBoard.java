import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.*;
import javax.swing.border.*;
public class printBoard{
    private JButton[][] boardSquares = new JButton[8][8];
    private JPanel board;
    private JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JToolBar tools = new JToolBar();
    private JButton b1;
    private Board newBoard = new Board();
    private int order = 1;
    private boolean gameover = false;
    public printBoard(){
        printHead();
    }

    public void update(){
        gui.removeAll();
        tools.removeAll();
        printHead();
    }

    public void printHead(){
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(b1 = new JButton("New"));
        /* Function of b1 */
        b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent a){
                    newBoard = new Board();
                    order = 1;
                    update();
                }
            });

        tools.addSeparator();
        int b = newBoard.countBlack();
        int w = newBoard.countWhite();
        if(b == 0 || w == 0 || b + w == 64){
            tools.add(new JLabel("Game Over"));
            gameover = true;
        }
        else if(order == 1){
            tools.add(new JLabel("White Turn"));
        }
        else{
            tools.add(new JLabel("Black Turn"));
        }
        order = (order++) % 2 + 1;
        
        tools.addSeparator();
        tools.add(new JLabel("Black: " + String.valueOf(b)));
        tools.add(new JLabel(" White: " + String.valueOf(w)));
        
        printMain();
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
                            if (source == boardSquares[i][j] && newBoard.check(order, i, j)){
                                update();
                            }
                        }
                    }
                }
            };

        Insets buttonMargin = new Insets(0,0,0,0);
        int available = 0;
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
                
                /* check for available spaces */
                if(available == 0 && newBoard.hasMove() == 0){
                    available++;
                }
            }
        }
        if(newBoard.hasMove() == 0){
            update();
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

    /* return Board back */
    public JComponent getBoard(){
        return gui;
    }
}