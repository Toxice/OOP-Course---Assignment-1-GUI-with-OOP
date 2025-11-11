package GUI.Lines;

import Basics.LinesAndPoints.Line;
import Basics.LinesAndPoints.Point;
import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class Made for Plotting Lines and Points
 */
public class AbstractArtDrawing {
    static final String Title = "Assignment Part 2 - Lines and Points";
    static final Random random = new Random();
    static final int width = 800;
    static final int height = 600;
    static final int number_of_lines = 10;

    static void main() {
        GUI gui = new GUI(Title, width, height);
        DrawSurface drawSurface = gui.getDrawSurface();
        ArrayList<Line> lines = new ArrayList<>();
        ArrayList<Point> middlePoints = new ArrayList<>();
        // Create Random Lines and Print them and their middle points to the DrawSurface
        for (int i = 0; i < number_of_lines; i++) {
            lines.add(new Line(random));
            lines.get(i).drawLine(drawSurface);
            middlePoints.add(lines.get(i).middle());
            middlePoints.get(i).drawPoint(drawSurface, false);
        }
        // Find All Intersections and draw them to the DrawSurface
        for (int i = 0; i < number_of_lines; i++) {
            for (int j = i + 1; j < number_of_lines; j++) {
                Point intersection = lines.get(i).intersectionWith(lines.get(j));
                if (intersection != null) {
                    intersection.drawPoint(drawSurface, true);
                }
            }
        }
      gui.show(drawSurface);
    }
}


