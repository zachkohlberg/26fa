public class CircleProgram2 {
    public static void main(String[] args) {
        Circle2 a = new Circle2(0, 0, 10);
        Circle2 b = new Circle2(5, 5, 5);
        b.setX(-2);
        b.setRadius(-5);

        printCircle("A", a);
        printCircle("B", b);
    }

    public static void printCircle(String name, Circle2 c) {
        System.out.printf(
                """
                Circle %s:
                    x             = %.2f
                    y             = %.2f
                    radius        = %.2f
                    area          = %.2f
                    circumference = %.2f
                """,
                name, c.getX(), c.getY(), c.getRadius(), c.getArea(), c.getCircumference());
    }
}
