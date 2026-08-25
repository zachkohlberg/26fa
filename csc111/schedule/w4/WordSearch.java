import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        // print a helpful error message instead of a stack trace on no argument
        // note that we're detecting something that would cause an exception and
        // never triggering the ArrayIndexOutOfBoundsException
        if (args.length != 2) {
            System.err.println("USAGE: java WordSearch.java FILE WORD");
            System.exit(1);
        }

        String filename = args[0];
        String word = args[1];

        File file = new File(filename);

        try {
            Scanner in = new Scanner(file);

            // the actual work our program wants to do
            search(in, word);

            // important to close scanners to free the underlying resources
            // not doing this will cause a memory leak
            in.close();
        } catch (FileNotFoundException e) {
            System.err.printf("File not found: %s\n", filename);
            System.exit(1);
        }
    }

    public static void search(Scanner in, String word) {
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.contains(word)) {
                System.out.printf("Found \"%s\" in line: \"%s\"\n", word, line);
            }
        }
    }
}
