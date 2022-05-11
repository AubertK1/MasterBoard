import javax.swing.*;
import java.awt.*;

public class Main {
    static MasterFrame frame;

    public static void main(String[] args) {
        //setting up the window
        frame = new MasterFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setCursor(Cursor.getDefaultCursor());
        /*
        //fixme just testing JList stuff. Remove later
        String days[] = { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday"};
        JList list = new JList(days);
        panel.add(list);
        mainPage.add(panel);
        mainPage.show();*/

    }
}
