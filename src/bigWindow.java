import darrylbu.icon.StretchIcon;


import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class bigWindow {
    static JLabel picLabel;

    public bigWindow(BufferedImage myPic) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout());
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 778;
        int height = 1000;
        frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);

        JPanel panel = new JPanel(new GridLayout());

        picLabel = new JLabel(new StretchIcon(myPic));

        panel.setPreferredSize(new Dimension(17, 22));


        panel.add(picLabel, new GridLayout());
        frame.add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static BufferedImage imgScale (BufferedImage before) {
        int w = before.getWidth();
        int h = before.getHeight();
        // Create a new image of the proper size
        int w2 = (int) (w * (8.5/11));
        int h2 = (h);
        BufferedImage after = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_ARGB);
        AffineTransform scaleInstance = AffineTransform.getScaleInstance(8.5/11, 1);
        AffineTransformOp scaleOp
                = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_BILINEAR);

        scaleOp.filter(before, after);
        return after;
    }
}