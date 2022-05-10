import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.ArrayList;

class Canvas {
    ArrayList<Drawing> drawings = new ArrayList<>();
    Brush brush; // the brush object can be modified with different sizes or colors
    static float diameter = 3;

    Canvas() {
        // here i use a default brush, but you can experiment different colors or sizes
        brush = new Brush(Color.BLACK, diameter);
    }

    void Update(Point mouseLoc) {

    }

    void Display(Graphics2D g, Point mouseLoc) {
        brush.Display(g, mouseLoc);
    }
}