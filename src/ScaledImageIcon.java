import javax.swing.*;
import java.awt.*;

class ScaledImageIcon extends ImageIcon {
    ScaledImageIcon(Image image, int height, int width) {
        super(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
    ScaledImageIcon(Image image, int height) {
        super(image.getScaledInstance((int)(height*(8.5/11)), height, Image.SCALE_SMOOTH));
    }
}