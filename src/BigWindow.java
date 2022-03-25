import darrylbu.icon.StretchIcon;


import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BigWindow {
    static JLabel picLabel;

    public BigWindow(BufferedImage myPic) {
        //setting up frame
        JFrame frame = new JFrame("Image");
        //giving grid layout so the image will automatically fill the window as it's resized
        frame.setLayout(new GridLayout());
        //finding the center of the screen
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        //setting window size and putting it in the center of the screen
        int width = 778;
        int height = 1000;
        frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        //creating panel
        JPanel panel = new JPanel(new GridLayout());
        //putting image as a label
        picLabel = new JLabel(new StretchIcon(myPic));
        //probably unimportant
        panel.setPreferredSize(new Dimension(17, 22));
        //adding label to panel
        panel.add(picLabel, new GridLayout());
        //adding panel to frame
        frame.add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0));
        //probably unimportant
        frame.setLocationRelativeTo(null);
        //making window visible
        frame.setVisible(true);
    }
}