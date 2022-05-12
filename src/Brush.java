import java.awt.*;
// this class is overdesigned so in the future you can change the brush's characteristics like the fade'S colors or simply it's size
class Brush {
    boolean highlight;
    static float diameter;
    static Color circleColor;

    Brush(Color circleColor, float diameter) {
        Brush.circleColor = circleColor;
        Brush.diameter = diameter+3;
    }

    void Display(Graphics h, Point mouseLoc) {
        Graphics2D g = (Graphics2D) h;
        g.setColor(circleColor);
        g.fillOval(mouseLoc.x-(int)(diameter/2), mouseLoc.y-(int)(diameter/2), (int)diameter, (int)diameter);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(1));
        g.drawOval(mouseLoc.x-(int)(diameter/2), mouseLoc.y-(int)(diameter/2), (int)diameter, (int)diameter);
        if(highlight){
            g.setColor(Color.BLUE);
            g.setStroke(new BasicStroke(diameter/9));
            g.drawOval(mouseLoc.x-(int)(diameter/2), mouseLoc.y-(int)(diameter/2), (int)diameter, (int)diameter);
        }

       /* stroke(circleColor);
        strokeWeight(5);
        testDrawingBoard.frame.noFill();
        ellipse(mouseX, mouseY, diameter, diameter);
        if (highlight) { // if the mouse's button is down, give visual feedback about the brush
            stroke(0);
            strokeWeight(4);
            ellipse(mouseX, mouseY, diameter, diameter);
            stroke(255);
            strokeWeight(3);
            ellipse(mouseX, mouseY, diameter, diameter);
        }

        */
    }
}
