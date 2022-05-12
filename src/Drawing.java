import java.awt.*;
import java.util.ArrayList;

public class Drawing extends MasterBoardItem{
    boolean mouseDown;
    boolean mouseReleased = true;
    ArrayList<Line> lines = new ArrayList<>(); // every line will be stored in this list
    Brush brush; // the brush object can be modified with different sizes or colors
    static float diameter = Panel.diameter;
    Color circleColor = Color.BLACK;

    public Drawing() {
    }

    void Update(Point mouseLoc) {
        Panel.canvas.brush.highlight = mouseDown; // so the user has visual feedback while drawing

        if (mouseDown) {
            if (mouseReleased) { // if this is a "new" line, add a line object to store it
                if(Panel.drawMode) {
                    if(Panel.eraseMode){
                        lines.add(new Line(Color.WHITE, diameter, 10));
                    }
                    else
                        lines.add(new Line(circleColor, diameter));
                }
/*                else if(Panel.eraseMode){
                    lines.get(lines.size() - 1).Remove(mouseLoc.x, mouseLoc.y);
                }*/
                mouseReleased = false;
            }
            // add a dot at the mouse's current position, then update the fading
            if(Panel.drawMode) {
                lines.get(lines.size() - 1).Add(mouseLoc.x, mouseLoc.y);
//                lines.get(lines.size() - 1).ApplyFade();
            }
/*            else if(Panel.eraseMode){
                lines.get(lines.size() - 1).Remove(mouseLoc.x, mouseLoc.y);
            }*/
        }
    }

    void Display(Graphics2D g, Point mouseLoc) {
        // for every Line, draw every Dot... then don't forget to display the brush!
        for (Line l : lines) {
            l.Draw(g);
        }
    }
}
