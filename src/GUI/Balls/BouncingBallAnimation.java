package GUI.Balls;

import Basics.Balls.Ball;
import Basics.LinesAndPoints.Point;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import biuoop.*;

public class BouncingBallAnimation {
    final static String Title = "Part 3 - Bouncing Balls";
    final static int Width = 200;
    final static int Height = 200;
    static void main(String[] args) {
        int xPoint = Integer.parseInt(args[0]);
        int yPoint = Integer.parseInt(args[1]);
        int dx = Integer.parseInt(args[2]);
        int dy = Integer.parseInt(args[3]);
        drawAnimation(new Point(xPoint,yPoint), dx, dy);
    }

    static private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI(Title, Width, Height);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), 30, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
