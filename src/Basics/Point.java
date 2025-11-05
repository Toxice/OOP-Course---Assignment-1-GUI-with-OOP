package Basics;

// a point has an x and a y value, and can measure the distance to other points, and if it is equal to another point.
public class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * calculating the distance between the current point and some other point
     * @param other: Point Object
     * @return double: the distance between current and other
     */
    public double distanceFrom(Point other) {
        double x2 = other.x;
        double y2 = other.y;
        double determinant = ((this.x-x2)*(this.x-x2))+((this.y-y2)*(this.y-y2)); // calculating the raw distance between this and other
        return Math.sqrt(determinant);
    }

    /**
     * comparing between the current point and some other point
     * @param other: Point Object
     * @return true iff x and y values of the two points are equal
     */
    public boolean equals(Point other) {
        return (this.x == other.x) && (this.y == other.y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    /**
     * checks if this point contains the other point
     * @param other: Point Object
     * @return true iff x and y values of other is less than or equal to the x and y values of this Point
     */
    public boolean contains(Point other) {
        return (other.getX() <= this.getX()) && (other.getY() <= this.getY());
    }

    /**
     * checks if this the other point contains this point
     * @param other: Point Object
     * @return true iff x and y values of this point is less than or equal to the x and y values of the other Point
     */
    public boolean containedIn(Point other) {
        return (this.getX() <= other.getX()) && (this.getY() <= other.getY());
    }
}
