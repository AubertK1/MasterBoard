import javafx.concurrent.Task;
import javafx.scene.shape.Polyline;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// A line is a bunch of dots and two colors (for the fade effect)
class Line {
    //makes a list to store the dots of the line
    ArrayList<Integer> xVals = new ArrayList<>();
    ArrayList<Integer> yVals = new ArrayList<>();
    ArrayList<Point> pVals = new ArrayList<>();
    ArrayList<Point> eVals = new ArrayList<>();
    ArrayList<Point> iVals = new ArrayList<>();

    Color colorFrom;
    float diameter;

    Line(Color colorFrom, float diameter) {
        this.colorFrom = colorFrom;
        this.diameter = diameter;
    }
    Line(ArrayList<Point> pVals, Color colorFrom, float diameter) {
        this.colorFrom = colorFrom;
        this.diameter = diameter;
        this.pVals = pVals;
    }
    void Add(int xVal, int yVal) {
        //adds dots to lists
//        xVals.add(xVal);
//        yVals.add(yVal);
        Point pVal = new Point(xVal, yVal);
//        if(!Panel.eraseMode) {

//        }
        pVals.add(new Point(pVal));
        if(Panel.eraseMode){
            AddE(pVal);
        }
        if(!Panel.eraseMode)
            pVals.add(new Point(pVal));
    }
    void AddE(Point pVal){
        eVals.add(new Point(pVal));
        if(eVals.size() > 2){
            splitLine(eVals.get(eVals.size()-1), eVals.get(eVals.size()-2));
        }
    }
    void Draw(Graphics2D g){
        //makes an array for the list so it can go into the drawPolyLine method
        int[] xValAr = new int[pVals.size()];
        int[] yValAr = new int[pVals.size()];
        Point[] pValsAr = new Point[pVals.size()];
        for (int i = 0; i < pValsAr.length; i++) {
            xValAr[i] = pVals.get(i).x;
        }
        for (int i = 0; i < pValsAr.length; i++) {
            yValAr[i] = pVals.get(i).y;
        }

        //sets the size of the line (will later be able to be changed by user)
        g.setStroke(new BasicStroke(diameter));
        g.setColor(colorFrom);
        g.drawPolyline(xValAr, yValAr, pValsAr.length);
    }
    void splitLine(Point E1, Point E2) {
//        Point E1 = new Point(1000, 1);
//        Point E2 = new Point(900, 1079);
        ArrayList<Drawing> drawings = Panel.canvas.drawings;
        for (int i = 0, drawingsSize = drawings.size(); i < drawingsSize; i++) {
            Drawing drawing = drawings.get(i);
            ArrayList<Line> lines = drawing.lines;
            for (int j = 0, linesSize = lines.size(); j < linesSize; j++) {
                Line line = lines.get(j);

                if (line.pVals.size() < 2) {
                    continue;
                }

                for (int p = 1; p < line.pVals.size(); p++) {
                    newFunc(line, drawing, p, E1, E2,lines);

                }
            }
        }
        ArrayList<Line> lines = Panel.drawing.lines;
        for (int i = 0, linesSize = lines.size()-1; i < linesSize; i++) {
            Line line = lines.get(i);

            if (line.pVals.size() < 2) {
                continue;
            }

            for (int p = 1; p < line.pVals.size(); p++) {
                newFunc(line, Panel.drawing, p, E1, E2,lines);

            }
        }
    }
    void newFunc( Line line, Drawing drawing, int p, Point E1, Point E2, ArrayList<Line> lines) {
        Point iVal = intersectLoc(line.pVals.get(p - 1), line.pVals.get(p), E1, E2);
        if (iVal != null) {
            iVals.add(iVal);
            //ArrayList<Task> tmp = new ArrayList<Task>(mTrackytAdapter.getAllTasks(token));
//            List<Point> L1 = line.pVals.subList(0, p);
//            List<Point> L2 = line.pVals.subList(p, line.pVals.size());
            ArrayList<Point> L1 = new ArrayList<>(line.pVals.subList(0, p));
            ArrayList<Point> L2 = new ArrayList<>(line.pVals.subList(p, line.pVals.size()));
            Point D1 = line.pVals.get(p - 1);
            Point D2 = line.pVals.get(p);
            double radius = diameter / 2;
            double x1 = iVal.x - radius;
            double x2 = iVal.x + radius;
            double slope = getSlope(D1, D2);
            double b1 = D1.y - slope * D1.x;
            double b2 = D2.y - slope * D2.x;
            double y1 = slope * x1 + b1;
            double y2 = slope * x2 + b2;
            Point P1 = new Point((int) x1, (int) y1);
            Point P2 = new Point((int) x2, (int) y2);
            L1.add(P1);
            line.pVals = L1;
            L2.add(0, P2);
            drawing.lines.add(drawing.lines.size()-1,new Line(L2, line.colorFrom, diameter));
        }
    }
    Point intersectLoc(Point D1, Point D2, Point E1, Point E2) {

        //find slope of eraser points
        double minDX = Math.min(D1.x, D2.x);
        double maxDX = Math.max(D1.x, D2.x);
        double minEX = Math.min(E1.x, E2.x);
        double maxEX = Math.max(E1.x, E2.x);
        double minDY = Math.min(D1.y, D2.y);
        double maxDY = Math.max(D1.y, D2.y);
        double minEY = Math.min(E1.y, E2.y);
        double maxEY = Math.max(E1.y, E2.y);
//        if(E1.x > E2.x){
//            minEX = E2.x;
//            maxEX = E1.x;
//        }
//        else{
//            minEX = E1.x;
//            maxEX = E2.x;
//        }
//        if(D1.x > D2.x){
//            minDX = D2.x;
//            maxDX = D2.x;
//        }
//        else{
//            minDX = D1.x;
//            maxDX = D2.x;
//        }
//        Point I1 = new Point(minDX, maxDX);
//        Point I2 = new Point(minEX, maxEX);
//
//        Point Ia = new Point(Math.max(minDX, minEX), Math.min(maxDX, maxEX));
//
//        if(maxDX<minEX){
//            return new Point(-1,-1);
//        }

        double A1 = ((double)D1.y-D2.y)/(D1.x-D2.x);
        double A2 = ((double)E1.y-E2.y)/(E1.x-E2.x);
        double b1 = D1.y-A1*D1.x;
        double b2 = E1.y-A2*E1.x;

//        if(A1==A2){
//            return new Point(-1,-1);
//        }

        double Xa = (b2 - b1) / (A1 - A2);
        double Ya = A1 * Xa + b1;


        if(Xa < minDX || Xa < minEX || Xa > maxDX || Xa > maxEX){
            return null;
        }
        if(Ya < minDY || Ya < minEY || Ya > maxDY || Ya > maxEY){
            return null;
        }

        if(!(Xa >= 0) || !(Ya >= 0)){
            return null;
        }
        return new Point((int)Xa,(int)Ya);
        //loop through points list and find slope of each two consecutive points
    }
    double getSlope(Point D1, Point D2){
        double A1 = ((double)D1.y-D2.y)/(D1.x-D2.x);
        return A1;
    }
    void splitLine(Point iVal, float diameter, int i, int r){
        ArrayList<Point> L1 = (ArrayList<Point>) Panel.drawing.lines.get(r).pVals.subList(0, i);
        ArrayList<Point> L2 = (ArrayList<Point>) Panel.drawing.lines.get(r).pVals.subList(i, Panel.drawing.lines.get(r).pVals.size());
        Point D1 = Panel.drawing.lines.get(r).pVals.get(i - 1);
        Point D2 = Panel.drawing.lines.get(r).pVals.get(i);
        double radius = diameter/2;
        double x1 = iVal.x - radius;
        double x2 = iVal.x + radius;
        double slope = getSlope(D1, D2);
        double b1 = D1.y-slope*D2.x;
        double y1 = slope * x1 + b1;
        double y2 = slope * x2 + b1;
        Point P1 = new Point((int)x1,(int) y1);
        Point P2 = new Point((int)x2,(int) y2);
        L1.add(P1);
        L2.add(0, P2);
        new Line(L2, colorFrom, diameter);
    }
    void Erase(Graphics2D g){
        //makes an array for the list so it can go into the drawPolyLine method
        int[] xValAr = new int[eVals.size()];
        int[] yValAr = new int[eVals.size()];
        for (int i = 0; i < xValAr.length; i++) {
            xValAr[i] = eVals.get(i).x;
        }
        for (int i = 0; i < yValAr.length; i++) {
            yValAr[i] = eVals.get(i).y;
        }

        //sets the size of the line (will later be able to be changed by user)
        g.setStroke(new BasicStroke(3));
        if(Panel.eraseMode)
            g.setColor(Color.white);
        else
            g.setColor(colorFrom);
        g.drawPolyline(xValAr, yValAr, xValAr.length);
    }
    /*    void Add(Dot d) {
    //        dots.add(d);
        }*/
    // This method calculate how many dots there are in the line to better distribute the shades of the fade
    void ApplyFade() {
      /*  for (int i=0; i<dots.size(); i++) {
            Dot d = dots.get(i);
            d.c = colorTo;
           // d.c = lerpColor(colorFrom, colorTo, (float) i/dots.size());
        }*/
    }
    void checkInt(){
        Point m = new Point(10, 10);
        Point n = new Point(100, 100);
        Polyline line = new Polyline(10, 100, 20, 300);
    }

    void Remove(int xVal, int yVal){
        for (int i = 0; i < xVals.size(); i++) {
            if(xVal == xVals.get(i)){
                getBet(pVals.get(i), pVals.get(i+1));
            }
        }
    }
    public Point[] getPoints(Point p1, Point p2, int quantity) {
        Point[] points = new Point[quantity];
        int ydiff = p2.y - p1.y, xdiff = p2.x - p1.x;
        double slope = (double)(p2.y - p1.y) / (p2.x - p1.x);
        double x, y;

        --quantity;

        for (double i = 0; i < quantity; i++) {
            y = slope == 0 ? 0 : ydiff * (i / quantity);
            x = slope == 0 ? xdiff * (i / quantity) : y / slope;
            points[(int)i] = new Point((int)Math.round(x) + p1.x, (int)Math.round(y) + p1.x);
        }

        points[quantity] = p2;
        return points;
    }
    void getBet(Point pStart, Point pEnd){
//        pStart = new Point(10, 10);
//        pEnd = new Point(100, 100);

        Point[] betPoints = new Point[10];
        for (int i = 1; i <= 10; i++)
        {
            betPoints[i].x = (Math.abs(pStart.x - pEnd.x) / 10) * i + pEnd.x;
            betPoints[i].y = (Math.abs(pStart.y - pEnd.y) / 10) * i + pEnd.y;
        }
    }
}

