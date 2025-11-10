package GUI.Balls;

import Basics.Balls.Ball;
import Basics.LinesAndPoints.Point;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.Random;

public class MultipleBouncingBallsAnimation {
    static Random random = new Random();
    // Keep these equal to Ball's Width/Height (Ball currently uses 200x200).
    static final int Width = 800;
    static final int Height = 600;
    static final String Title = "Part 3 - Multiple Balls";

    static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java MultipleBouncingBallsAnimation <size1> <size2> ...");
            return;
        }

        Ball[] balls = new Ball[args.length];
        for (int i = 0; i < args.length; i++) {
            int radius = Integer.parseInt(args[i]);
            // random center, but inside bounds (considering radius)
            int x = random.nextInt(Math.max(1, Width - 2 * radius)) + radius;
            int y = random.nextInt(Math.max(1, Height - 2 * radius)) + radius;
            Ball b = new Ball(new Point(x, y), radius, Ball.pickRandomColor());
            balls[i] = b;
        }
        drawAnimation(balls);
    }

    static private void drawAnimation(Ball[] balls) {
        GUI gui = new GUI(Title, Width, Height);
        Sleeper sleeper = new Sleeper();

        // assign random velocities (including negative values)
        for (Ball ball : balls) {
            int dx = random.nextInt(11) - 5; // -5 .. 5
            int dy = random.nextInt(11) - 5; // -5 .. 5
            if (dx == 0) dx = 1;
            if (dy == 0) dy = 1;
            ball.setVelocity(dx, dy);
        }

        // main animation loop: single surface per frame, draw all balls then show
        while (true) {
            DrawSurface d = gui.getDrawSurface();

            // clear background
            d.setColor(java.awt.Color.WHITE);
            d.fillRectangle(0, 0, Width, Height);

            // move + draw all balls onto the same surface
            for (Ball ball : balls) {
                ball.moveOneStep();
                ball.drawOn(d);
            }

            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
