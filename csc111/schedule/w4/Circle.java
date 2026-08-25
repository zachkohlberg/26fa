// previous Circle2 example with an added default constructor and toString method
public class Circle {
    private double x, y;
    private double radius;

    public Circle() {
        this.setX(0);
        this.setY(0);
        this.setRadius(0);
    }

    public Circle(double initX, double initY, double initRadius) {
        this.setX(initX);
        this.setY(initY);
        this.setRadius(initRadius);
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public void setRadius(double newRadius) {
        if (newRadius < 0) {
            this.radius = 0;
        } else {
            this.radius = newRadius;
        }
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.radius;
    }

    public String toString() {
        return String.format("Circle(center: (%.02f, %.02f), radius: %.02f)", x, y, radius);
    }
}
