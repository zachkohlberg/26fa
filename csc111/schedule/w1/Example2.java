// imports the Scanner class so we don't have to keep typing the package
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        // a scanner can read from stdin using System.in
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        System.out.printf("Hello, %s. Nice to meet you!\n", name);

        // make small talk
        System.out.println("How was your first week of classes?");
        in.nextLine();
        System.out.println("Uh-huh, very interesting.");

        name = "";

        // in Java 25, we also have the IO class for stdin and stdout
        IO.println("Oops, I forgot your name!");
        name = IO.readln("What did you say it was? ");
        IO.println("Okay, thanks! I'll defininitely remember this time.");
        name = "";

        // make sure user is done
        String answer = IO.readln("Are you done using this program?\n");
        while (!answer.equalsIgnoreCase("yes")) {
            answer = IO.readln("How about now?\n");
        }

        // are they really done?
        do {
            answer = IO.readln("Are you sure you're done?\n");
        } while (!answer.equals("yes"));

        IO.println("Goodbye!");
    }
}
