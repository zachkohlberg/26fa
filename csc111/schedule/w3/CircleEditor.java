import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CircleEditor {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        Circle circle = new Circle();

        boolean done = false;
        while (!done) {
            System.out.println(circle);
            System.out.print("Enter command: ");
            String[] command = stdin.nextLine().split(" ");

            switch (command[0]) {
                case "quit", "q":
                    done = true;
                    break;
                case "x":
                    double x = Double.parseDouble(command[1]);
                    circle.setX(x);
                    break;
                case "y":
                    double y = Double.parseDouble(command[1]);
                    circle.setY(y);
                    break;
                case "radius", "r":
                    double radius = Double.parseDouble(command[1]);
                    circle.setRadius(radius);
                    break;
                case "save":
                    saveCircle(circle, command[1]);
                    break;
                case "load":
                    circle = loadCircle(command[1]);
                    break;
                default:
                    System.out.printf("Invalid command: \"%s\"", command[0]);
            }
        }

        System.out.println("Goodbye!");
    }

    public static void saveCircle(Circle c, String filename) {
        // try with resources pattern will close the writer for us
        try (PrintWriter fileOut = new PrintWriter(new File(filename))) {
            fileOut.println(c.getX());
            fileOut.println(c.getY());
            fileOut.println(c.getRadius());
        } catch (FileNotFoundException e) {
            // if the file wasn't created, then we might see this error
            System.out.printf("File \"%s\" not found.\n", filename);
        }
    }

    public static Circle loadCircle(String filename) {
        // try with resources pattern will close the scanner for us
        try (Scanner fileIn = new Scanner(new File(filename))) {
            double x = fileIn.nextDouble();
            double y = fileIn.nextDouble();
            double radius = fileIn.nextDouble();
            return new Circle(x, y, radius);
        } catch (FileNotFoundException e) {
            System.out.printf("File \"%s\" not found.\n", filename);
            return null;
        }
    }
}
