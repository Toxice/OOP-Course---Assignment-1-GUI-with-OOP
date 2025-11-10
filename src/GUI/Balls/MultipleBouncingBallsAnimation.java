package GUI.Balls;

import Basics.Balls.Ball;
import Basics.LinesAndPoints.Point;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.Random;

public class MultipleBouncingBallsAnimation {
    static Random random = new Random();
    static final int Width = 400;
    static final int Height = 400;
    static final String Title = "Part 3 - Multiple Balls";

    static void main(String[] args) {
        Ball[] balls = new Ball[6];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(new Point(random.nextInt(Width / 2)+ 1,
                    random.nextInt(Height / 2) + 1),
                    random.nextInt(10), Ball.pickRandomColor(8));
        }
        drawAnimation(balls);

    }

    static private void drawAnimation(Ball[] balls) {
        GUI gui = new GUI(Title, Width, Height);
        Sleeper sleeper = new Sleeper();
        for (Ball ball : balls) {
            ball.setVelocity(random.nextInt(10) + 1, random.nextInt(10) + 1);
        }
        while (true) {
            for (Ball ball : balls) {
                ball.moveOneStep();
                DrawSurface d = gui.getDrawSurface();
                ball.drawOn(d);
                gui.show(d);
                sleeper.sleepFor(200);  // wait for 50 milliseconds.
            }
        }
    }
}
