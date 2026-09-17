import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ListTest {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String cmd = "";

        String help =
                """
                Type one of the following commands:

                new CAPACITY
                    make a new list with the given CAPACITY and discard the old list
                load FNAME
                    load the list from the file FNAME
                save FNAME
                    save the list to the file FNAME (be careful not to overwrite anything important!)
                add N0 N1 N2...
                    adds each number after the command to the list
                rem N0 N1 N2...
                    removes one copy of each number after the command from the list
                print
                    prints the list
                help
                    prints this help message
                quit
                    exits the program
                """;

        System.out.println("Welcome to the list test program!\n" + help);
        UnorderedIntList list = new UnsortedIntArrayList(10);
        while (!cmd.equalsIgnoreCase("quit") && !cmd.equalsIgnoreCase("q")) {
            System.out.print("> ");
            cmd = stdin.nextLine();

            String[] parts = cmd.split(" ");
            switch (parts[0].toLowerCase()) {
                case "n", "new" -> {
                    try {
                        int capacity = Integer.parseInt(parts[1]);
                        list = new UnsortedIntArrayList(capacity);
                    } catch (NumberFormatException e) {
                        System.out.println("Capacity must be an integer.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Must include a capacity for the new command.");
                    } catch (NegativeArraySizeException e) {
                        System.out.println("Capacity must be nonnegative.");
                    }
                }
                case "l", "load" -> {
                    try {
                        list = loadList(parts[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Loading requires a filename!");
                    } catch (FileNotFoundException e) {
                        System.out.println("Failed to load file.");
                    }
                }
                case "s", "save" -> {
                    try {
                        saveList(parts[1], list);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Saving requires a filename!");
                    } catch (FileNotFoundException e) {
                        System.out.println("Failed to save file.");
                    }
                }
                case "a", "add" -> {
                    for (int i = 1; i < parts.length; i++) {
                        try {
                            list.add(Integer.parseInt(parts[i]));
                        } catch (NumberFormatException e) {
                            System.out.println("Can only add integers to the list.");
                        }
                    }
                }
                case "r", "rem" -> {
                    for (int i = 1; i < parts.length; i++) {
                        try {
                            list.remove(Integer.parseInt(parts[i]));
                        } catch (NumberFormatException e) {
                            System.out.println("Can only remove integers from the list.");
                        }
                    }
                }
                case "p", "print" -> {
                    int[] data = list.toArray();
                    System.out.print("{");
                    for (int i = 0; i < data.length; i++) {
                        System.out.print(" ");
                        System.out.print(data[i]);
                        if (i < data.length - 1) {
                            System.out.print(",");
                        }
                    }
                    System.out.println(" }");
                }
                case "h", "help" -> System.out.println(help);
                case "q", "quit" -> System.out.println("Quitting!");
                default -> System.out.println("Invalid command. Type \"help\" for help.");
            }
        }

        stdin.close();
    }

    public static UnorderedIntList loadList(String fname) throws FileNotFoundException {
        // NOTE: you can use a try with resource block to handle closing, but you should
        // NOT catch any exceptions. The main method's code will handle the exceptions
        // for you. There's nothing interesting to do when the exception occurs anyway,
        // so there's little point in having you handle it here.
        try (Scanner file = new Scanner(new File(fname))) {
            int capacity = Integer.parseInt(file.nextLine());
            int size = Integer.parseInt(file.nextLine());
            UnorderedIntList list = new UnsortedIntArrayList(capacity);
            for (int i = 0; i < size; i++) {
                list.add(Integer.parseInt(file.nextLine()));
            }
            return list;
        }
    }

    public static void saveList(String fname, UnorderedIntList list) throws FileNotFoundException {
        // See loadList's note about exceptions.
        try (PrintWriter file = new PrintWriter(new File(fname))) {
            file.println(list.capacity());
            file.println(list.size());
            int[] data = list.toArray();
            for (int i = 0; i < list.size(); i++) {
                file.println(data[i]);
            }
        }
    }
}
