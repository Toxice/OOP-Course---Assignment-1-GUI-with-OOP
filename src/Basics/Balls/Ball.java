package Basics.Balls;

import Basics.LinesAndPoints.Point;
import biuoop.DrawSurface;

import java.awt.*;

/**
 * Ball Object, made of a Point representing its center,
 * an int representing its radius,
 * and a Color representing its Color
 */
public class Ball {
    Point Center;
    int Radius;
    Color color;
    Velocity velocity;

    static final int Width = 200;
    static final int Height = 200;

    public Ball(Point point, int r, Color color) {
        this.Center = point;
        this.Radius = r;
        this.color = color;
    }

    public Ball(double _x, double _y, int radius, Color color) {
        this(new Point(_x, _y), radius, color);
    }

    public int getX() {
        return (int)Math.round(this.Center.getX());
    }

    public int getY() {
        return (int)Math.round(this.Center.getY());
    }

    public int getSize() {
        return this.Radius;
    }

    public Color getColor() {
        return this.color;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    public Velocity getVelocity() {
        return this.velocity;
    }

    public void moveOneStep() {
        if (this.Center.getX() >= Width) {
            this.Center.setX(-(this.Center.getX()));
            return;
        }
        if (this.Center.getY() >= Height) {
            this.Center.setY(-(this.Center.getY()));
            return;
        }
        this.Center = this.getVelocity().applyToPoint(this.Center);
    }

    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(this.getColor());
        drawSurface.fillCircle(this.getX(), this.getY(), this.getSize());
    }
}
