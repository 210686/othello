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
    private JLabel label;
    private JToolBar tools = new JToolBar();
    private JButton b1;
    private Board newBoard = new Board();

    public printBoard(){
        gui.removeAll();
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(b1 = new JButton("New"));
        /* Function of b1 */
        b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent a){
                    System.out.println("Hello World");
                    new printBoard();
                }
            });

        tools.addSeparator();
        tools.add(label = new JLabel("")); //Add text
        tools.addSeparator();

        board = new JPanel(new GridLayout(0, 9));
        board.setBorder(new LineBorder(Color.BLACK));
        gui.add(board);

        ActionListener listener = new ActionListener(){
                int x = -1, y = -1;
                public void actionPerformed(ActionEvent a){
                    /* Add functionality */
                }
            };

        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);

                /* Add graphics here */
                b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                try{
                    ImageIcon icon = new ImageIcon(newBoard.getImage(i, j));
                    b.setIcon(icon);
                }catch(NullPointerException e){}
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
    }

    /* return Board back */
    public JComponent getBoard(){
        return gui;
    }

    public JPanel drawCircle(){
        JPanel p = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g;
                    Shape circle = new Ellipse2D.Double(16, 16, 64, 64);
                    g2.draw(circle);
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                }
            };
        return p;
    }
}