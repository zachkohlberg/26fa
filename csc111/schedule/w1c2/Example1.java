// program must go in a class
public class Example1 {
    // main is the entry point for the program
    public static void main(String[] args) {
        // printing to stdout and stderr
        System.out.print("stdout message with no linebreak");
        System.out.println("stdout message with a linebreak");
        System.out.printf("formatted %s message\n", "stdout");
        System.err.println("stderr message");

        // command line arguments are a form of user input
        System.out.printf("there were %d command line arguments:\n", args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
