package Basics;

/**
 * Line Object, made of two Point Objects
 * start - start Point
 * end - end Point
 * slope - the slope of the line
 * intercept - the b point of the line (y = mx + b)
 */
public class Line {
    Point start;
    Point end;
    private final double slope;
    private final double intercept;

    /**
     * Take two Point Objects and create a Line from them
     * @param start: Point
     * @param end: Point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        this.intercept = calIntercept();
    }

    /**
     * Take Four Coordinates and make two Points and Make a Line from them
     * @param x1: coordinate
     * @param y1: coordinate
     * @param x2: coordinate
     * @param y2: coordinate
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.slope = (y2 - y1 / (x2 - x1));
        this.intercept = calIntercept();
    }

    /**
     * Calculate the Length of the Line
     * @return the length of the line, made of the distance between two Points
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Find The Middle Point of the Line
     * @return the middle Point, takes the average of two Points
     */
    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    public Point getStart() {
        return this.start;
    }

    public Point getEnd() {
        return this.end;
    }

    /**
     * Meant to Check if This Line intersects if any other lines
     * @param other: Line Object
     * @return true iff This intersects with other Line, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (this.getSlope() == other.getSlope()) {
            return false;
        } else {

        }
    }

    public Point IntersectionWith() {
        return new Point(5,3);
    }


    private boolean isTheSameLine(Line other) {
        double b1 = this.getStart().getY() - this.getSlope() * this.getStart().getX();
        double b2 = other.getStart().getY() - other.getSlope() * other.getStart().getX();
        return (this.getSlope() == other.getSlope()) && (b1 == b2);
    }


    private double getSlope() {
        return slope;
    }

    private double getIntercept() {
        return this.intercept;
    }

    private double calIntercept() {
        return this.getEnd().getY() - getSlope() * this.getEnd().getX();
    }

    /**
     * Check's if other Line is contained in this Line
     *
     * @param other: Line Object
     * @return true iff the Points of the other Line is contained in the Points of this Line
     */
    private boolean isLineContained(Line other) {
//        return this.getStart().contains(other.getStart()) && this.getEnd().contains(other.getEnd());
    }

    /**
     * Check's if Other Line is contained in this Line
     * @param other: Line Object
     * @return true iff the slopes of this Point and Other Point are equal, their b values are equal and the Other's Points are contained
     * in this Line's Points
     */
    private boolean contains(Line other) {
        if ((this.getSlope() == other.getSlope()) && (this.getIntercept() == other.getIntercept())) {
            // if both lines have the same slope and same b point
            return isLineContained(other);
        } return false;
    }

    /**
     * Check's if a Point is contained in this Line
     * @param point: Point object
     * @return true iff start and end contains point
     */
    private boolean contains(Point point) {
//        return this.getStart().contains(point) && this.getEnd().contains(point);
    }
}
