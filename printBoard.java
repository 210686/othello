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
        if(order == 1){
            tools.add(new JLabel("Player 1's Turn"));
        }
        else{
            tools.add(new JLabel("Player 2's Turn"));
        }
        order = (order++) % 2 + 1;
        tools.addSeparator();

        printMain();
    }
    public void printMain(){
        board = new JPanel(new GridLayout(0, 9));
        board.setBorder(new LineBorder(Color.BLACK));
        
        /* Action for the board Buttons */
        ActionListener listener = new ActionListener(){
                int x = -1, y = -1;
                public void actionPerformed(ActionEvent a){
                    /* Add functionality */
                    update();
                }
            };

        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);

                /* Add graphics here */
                b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                ImageIcon icon = new ImageIcon(newBoard.getImage(i, j));
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

    /* return Board back */
    public JComponent getBoard(){
        return gui;
    }
}