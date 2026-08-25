public class CircleProgram {
    public static void main(String[] args) {
        Circle a = new Circle(0, 0, 10);
        Circle b = new Circle(5, 5, 5);

        printCircle("A", a);
        printCircle("B", b);
    }

    static void printCircle(String name, Circle c) {
        System.out.printf(
                """
                Circle %s:
                    x             = %.2f
                    y             = %.2f
                    radius        = %.2f
                    area          = %.2f
                    circumference = %.2f
                """,
                name, c.x, c.y, c.radius, c.getArea(), Circle.getCircumference(c));
    }
}
