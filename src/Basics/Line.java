package Basics;

public class Line {
    Point start;
    Point end;
    private final double slope;
    private final double B;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        this.B = calB();
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.slope = (y2 - y1 / (x2 - x1));
        this.B = calB();
    }

    public double length() {
        return this.start.distanceFrom(this.end);
    }

    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    public Point getStart() {
        return this.start;
    }

    public Point getEnd() {
        return this.end;
    }


    public boolean isIntersecting(Line other) {
        return true;
    }


    private boolean isTheSameLine(Line other) {
        double b1 = this.getStart().getY() - this.getSlope() * this.getStart().getX();
        double b2 = other.getStart().getY() - other.getSlope() * other.getStart().getX();
        return (this.getSlope() == other.getSlope()) && (b1 == b2);
    }


    private double getSlope() {
        return slope;
    }

    private double getB() {
        return this.B;
    }

    private double calB() {
        return this.getEnd().getY() - getSlope() * this.getEnd().getX();
    }

    /**
     * Check's if other Line is contained in this Line
     *
     * @param other: Line Object
     * @return true iff the Points of the other Line is contained in the Points of this Line
     */
    private boolean isLineContained(Line other) {
        return this.getStart().contains(other.getStart()) && this.getEnd().contains(other.getEnd());
    }

    /**
     * Check's if Other Line is contained in this Line
     * @param other: Line Object
     * @return true iff the slopes of this Point and Other Point are equal, their b values are equal and the Other's Points are contained
     * in this Line's Points
     */
    private boolean contains(Line other) {
        if ((this.getSlope() == other.getSlope()) && (this.getB() == other.getB())) {
            // if both lines have the same slope and same b point
            return isLineContained(other);
        } return false;
    }
}
