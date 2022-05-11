import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Panel extends JPanel implements MouseListener, ActionListener, KeyListener {
    static float diameter = 3;

    public Panel (LayoutManager layout){
        super(layout);
        canvas = new Canvas();
    }
    static boolean newDraw = false;
    static boolean drawMode = false;
    static boolean eraseMode = false;
    static Canvas canvas;
    static Drawing drawing = new Drawing();
    Point mouseLoc = MouseInfo.getPointerInfo().getLocation();

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1 && !newDraw) {
            System.out.println("double clicked");
//            Drawing drawing = new Drawing(3);
//            canvas.drawings.add(drawing);
            newDraw = true;
            drawMode = true;


        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(drawMode) {
            drawing.mouseDown = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(drawMode) {
            drawing.mouseReleased = true;
            drawing.mouseDown = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
/*        // Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        // Set the blank cursor to the JFrame.
        Main.frame.getContentPane().setCursor(blankCursor);*/
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mouseLoc.x = MouseInfo.getPointerInfo().getLocation().x-1000;
        mouseLoc.y = MouseInfo.getPointerInfo().getLocation().y-50;
        if(drawMode) {
            drawing.Update(mouseLoc);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics H) {
        Graphics2D g = (Graphics2D) H;
        super.paintComponent(g);
        canvas.Display(g, mouseLoc);
        if(drawMode) {
            drawing.Display(g, mouseLoc);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            if(eraseMode){
                for (int i = 0; i < drawing.lines.size(); i++) {
                    if(drawing.lines.get(i).eVals.size() > 0) {
                        drawing.lines.remove(drawing.lines.get(i));
                    }
                }
            }
            drawMode = true;
            eraseMode = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_E){
            drawMode = true;
            eraseMode = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_P){
            String l = "Eraser Points: ";
            for (int i = 0; i < drawing.lines.size(); i++) {
                l = l+drawing.lines.get(i).eVals;
            }
            System.out.println(l);
        }
        else if(e.getKeyCode() == KeyEvent.VK_L){
            String l = "Draw Points: ";
            for (int i = 0; i < drawing.lines.size(); i++) {
                l = l+drawing.lines.get(i).pVals;
            }
            System.out.println(l);
        }
        else if(e.getKeyCode() == KeyEvent.VK_I){
            String l = "Intersect Points: ";
            for (int i = 0; i < drawing.lines.size(); i++) {
                l = l+drawing.lines.get(i).iVals;
            }
            System.out.println(l);
        }
        else if(e.getKeyCode() == KeyEvent.VK_1){
            diameter = 3;
            Canvas.diameter = 3;
            Drawing.diameter = 3;
            Brush.diameter = 3+3;
        }
        else if(e.getKeyCode() == KeyEvent.VK_2){
            diameter = 5;
            Canvas.diameter = 5;
            Drawing.diameter = 5;
            Brush.diameter = 5+3;
        }
        else if(e.getKeyCode() == KeyEvent.VK_3){
            diameter = 7;
            Canvas.diameter = 7;
            Drawing.diameter = 7;
            Brush.diameter = 7;
        }
        else if(e.getKeyCode() == KeyEvent.VK_4){
            diameter = 10;
            Canvas.diameter = 10;
            Drawing.diameter = 10;
            Brush.diameter = 10;
        }
        else if(e.getKeyCode() == KeyEvent.VK_5){
            diameter = 15;
            Canvas.diameter = 15;
            Drawing.diameter = 15;
            Brush.diameter = 15;
        }
        else if(e.getKeyCode() == KeyEvent.VK_6){
            diameter = 20;
            Canvas.diameter = 20;
            Drawing.diameter = 20;
            Brush.diameter = 20;
        }
        else if(e.getKeyCode() == KeyEvent.VK_7){
            diameter = 30;
            Canvas.diameter = 30;
            Drawing.diameter = 30;
            Brush.diameter = 30;
        }
        else if(e.getKeyCode() == KeyEvent.VK_MINUS && diameter > 2){
            diameter = diameter - 2;
            Canvas.diameter = Canvas.diameter - 2;
            Drawing.diameter = Drawing.diameter - 2;
            Brush.diameter = Brush.diameter - 2;
        }
        else if(e.getKeyCode() == KeyEvent.VK_EQUALS){
            diameter = diameter + 2;
            Canvas.diameter = Canvas.diameter + 2;
            Drawing.diameter = Drawing.diameter + 2;
            Brush.diameter = Brush.diameter + 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}