package GUI.Lines;

import Basics.Line;
import Basics.Point;
import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class Made for Plotting Lines and Points
 */
public class AbstractArtDrawing {
    static Random random = new Random();
    static final String Title = "Assignment Part 2 - Lines and Points";
    static final int width = 800;
    static final int height = 600;

    /**
     * Main Function
     */
    static void main() {
        ArrayList<Line> lines = setLines();
        ArrayList<Point> MiddlePoints = getMiddlePoints(lines);
        ArrayList<Point> IntersectionPoints = getIntersectionPoints(lines);
        GUI gui = new GUI(Title, width, height);
        DrawSurface drawSurface = gui.getDrawSurface();
        drawLines(lines, drawSurface);
        drawMiddlePoints(MiddlePoints, drawSurface);
        drawIntersectionPoints(IntersectionPoints, drawSurface);

        gui.show(drawSurface);
    }

    /**
     * Creates a Line from x,y coordinates
     *
     * @param x1: coordinate
     * @param y1: coordinate
     * @param x2: coordinate
     * @param y2: coordinate
     * @return a new Line
     */
    public static Line createLine(double x1, double y1, double x2, double y2) {
        return new Line(x1, y1, x2, y2);
    }

    public static void drawLines(ArrayList<Line> lines, DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLACK);
        for (Line line : lines) {
            System.out.println();
            drawSurface.drawLine((int)Math.round(line.getStart().getX()), (int)Math.round(line.getStart().getY()), (int)Math.round(line.getEnd().getX())
                    ,(int)Math.round(line.getEnd().getY()));
        }
    }

    /**
     * Draws the Intersection Point of two Lines
     *
     * @param intersectionPoints: Point ArrayList
     * @param drawSurface: DrawSurface Object
     */
    public static void drawIntersectionPoints(ArrayList<Point> intersectionPoints, DrawSurface drawSurface) {
        drawSurface.setColor(Color.RED);
        for (Point intersectionPoint : intersectionPoints) {
            int ix = (int)intersectionPoint.getX();
            int iy = (int)intersectionPoint.getY();
            System.out.println("Draw Point at: (" + ix + "," + iy + ")");
            drawSurface.fillCircle((int)Math.round(intersectionPoint.getX()), (int)Math.round(intersectionPoint.getY()), 3);
        }
    }

    public static void drawMiddlePoints(ArrayList<Point> middlePoints, DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLUE);
        for (Point middle : middlePoints) {
            drawSurface.fillCircle((int)Math.round(middle.getX()), (int)Math.round(middle.getY()), 3);
        }
    }

    public static ArrayList<Line> setLines() {
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
                lines.add(createLine(random.nextInt(width / 2) + 1, random.nextInt(height / 2) + 1,
                        random.nextInt(width / 2) + 1, random.nextInt(height / 2) + 1));
        }
        return lines;
    }

    public static ArrayList<Point> getMiddlePoints(ArrayList<Line> lines) {
        ArrayList<Point> middlePoints = new ArrayList<>(lines.size());
        for (Line line : lines) {
            middlePoints.add(line.middle());
        }
        return middlePoints;
    }

    public static boolean isIntersects(Line line, Line other) {
        return line.isIntersecting(other) && (line.intersectionWith(other) != null);
    }

    public static Point getIntersectionPoint(Line line, Line other) {
        return line.intersectionWith(other);
    }

    public static ArrayList<Point> getIntersectionPoints(ArrayList<Line> lines) {
        ArrayList<Point> intersectionPoints = new ArrayList<>();
        for (int i = 0; i < lines.size(); ++i) {
            for (int j = i + 1; j < lines.size(); ++j) {
               Line lineI = lines.get(i);
               Line lineJ = lines.get(j);
               if (isIntersects(lineI, lineJ)) {
                   Point intersectionPoint = getIntersectionPoint(lineI, lineJ);
                   if (intersectionPoint != null) {
                       intersectionPoints.add(intersectionPoint);
                   }
                }
            }
        }
        return intersectionPoints;
    }
    /*
    for (int i = 0; i < lines.size(); ++i) {
    for (int j = i + 1; j < lines.size(); ++j) {   // <--- only check each unordered pair once
        Line a = lines.get(i);
        Line b = lines.get(j);
        if (isIntersects(a, b)) {
            Point p = getIntersectionPoint(a, b);
            if (p != null) {
                // optionally avoid adding duplicates:
                if (!intersectionPoints.contains(p)) {
                    intersectionPoints.add(p);
                }
            }
        }
    }
}
     */

}


