public class Example3 {
    public static void main(String[] args) {
        // if there are no program args, then the program ends!
        if (args.length == 0) {
            System.out.println("Sorry, I need program args.");
            // ends the program early
            // exiting with a nonzero value indicates to other programs that
            // something went wrong
            System.exit(1);
        }

        // check whether there are an even or odd number of args
        if (args.length % 2 == 0) {
            System.out.println("Even arg count detected!");
            // call another static method
            even(args);
        } else {
            System.out.println("Odd arg count detected!");
            // call another static method
            odd(args);
        }
    }

    public static void even(String[] args) {
        // print only the even-numbered args
        for (int i = 1; i < args.length; i += 2) {
            // our target audience is non-programmers, and their brains aren't
            // zero-indexed
            System.out.printf("%d. %s\n", i + 1, args[i]);
        }
    }

    public static void odd(String[] args) {
        // print only the characters encoded as odd numbers
        // why are we doing that? hey, look! an enhanced for loop!
        for (String arg : args) {
            // wow, a nested loop!
            for (int i = 0; i < arg.length(); i++) {
                // get character
                char c = arg.charAt(i);
                // checking if odd
                if (c % 2 != 0) {
                    System.out.print(c);
                }
            }
            // line break after each arg
            System.out.println();
        }
    }
}
