import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import javax.swing.*;
import javax.swing.border.*;
public class printBoard{
    private final static Color BG = new Color(0, 102, 0);

    private JButton[][] boardSquares = new JButton[8][8];
    private JPanel board;
    private JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JLabel label;
    private JToolBar tools = new JToolBar();
    private JButton b1;

    public printBoard(){
        gui.removeAll();
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(b1 = new JButton("New")); //Add functionality
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
                
                BufferedImage bi = new BufferedImage(64, 64, BufferedImage.TYPE_3BYTE_BGR);
                Graphics2D graphics = bi.createGraphics();
                graphics.setPaint(BG);
                graphics.fillRect(0, 0, bi.getWidth(), bi.getHeight());
                ImageIcon icon = new ImageIcon(bi);
                
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
    }

    /* return stuff back */
    public JComponent getBoard(){
        return gui;
    }
}