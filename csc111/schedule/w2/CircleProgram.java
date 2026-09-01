class CircleProgram {
    static void main(String[] args) {
        // a circle is defined by three values
        double x = 11;
        double y = 8;
        double radius = 6;

        // note: we can call these methods with any arbitrary values
        printCircle(10, -4, 15);

        // use methods with our variables
        printCircle(x, y, radius);
        drawCircle(x, y, radius);
    }

    static void printCircle(double x, double y, double radius) {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;

        System.out.printf(
                // a multiline string literal isn't necessary, but it's easier to read our
                // format string like this
                """
                CIRCLE
                    CENTER: (%.2f, %.2f)
                    RADIUS: %.2f
                    AREA: %.2f
                    CIRCUMFERENCE: %.2f
                """,
                x, y, radius, area, circumference);
    }

    static boolean containsPoint(double cx, double cy, double cr, double px, double py) {
        double dx = cx - px;
        double dy = cy - py;
        // squaring the radius is faster than taking the square root of (dx^2 + dy^2)
        return dx * dx + dy * dy <= cr * cr;
    }

    // we can use containsPoint to make some simple ascii art
    static void drawCircle(double cx, double cy, double cr) {
        for (int y = 0; y < 30; y++) {
            for (int x = 0; x < 80; x++) {
                if (containsPoint(cx, cy, cr, x, y)) {
                    System.out.print('O');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}
