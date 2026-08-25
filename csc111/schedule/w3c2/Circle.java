class Circle {
    double x, y;
    double radius;

    Circle(double initX, double initY, double initRadius) {
        this.x = initX;
        this.y = initY;
        this.radius = initRadius;
    }

    double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    static double getCircumference(Circle c) {
        return 2 * Math.PI * c.radius;
    }
}
