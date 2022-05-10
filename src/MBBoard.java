import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MBBoard {
    static JFrame frame;
    public MBBoard() {
        frame = new JFrame("testDrawingBoard");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//            frame.getContentPane().setLayout(new GridBagLayout());
        // frame.setVisible(true);
        Panel panel = new Panel(null);

//            BufferedImage img = ImageIO.read(new File("C:\\Users\\ak2000\\Documents\\Priv\\testDrawingBoard\\src\\white.png"));
//            BufferedImage img = ImageIO.read(new File("C:\\Users\\auber\\OneDrive\\Pictures\\Random\\white.png"));

        panel.addMouseListener(panel);
        panel.addKeyListener(panel);
        Timer timer = new Timer(1, panel);
        frame.setUndecorated(true);
//            JLabel board = new JLabel(new ImageIcon(img));
//            panel.add(board, null);
        panel.setBackground(Color.GREEN);
        panel.setFocusable(true);
        frame.add(panel);
//            frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.requestFocus();
        timer.start();
    }
}
