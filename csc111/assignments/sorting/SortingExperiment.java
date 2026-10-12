import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author YOUR NAME HERE
 */
public class SortingExperiment {
    public static final int TRIALS = 5;

    public static void main(String[] args) {
        // TODO: SortHelper.setSeed(?);

        // arrays to store our data from each trial
        int[] bubbleComps = new int[TRIALS];
        int[] bubbleSwaps = new int[TRIALS];
        // TODO

        // run the experiment
        for (int i = 0; i < TRIALS; i++) {
            // each trial involves a larger array
            int length = (i + 1) * 10_000;

            // make identical random arrays for each algorithm
            int[] originalArray = SortHelper.randomArray(length);
            int[] bubbleArray = SortHelper.copy(originalArray);
            // TODO

            // instantiate algorithms
            BubbleSort bubble = new BubbleSort();
            // TODO

            // sort
            bubble.sort(bubbleArray, 0, bubbleArray.length);
            // TODO

            // record results
            bubbleComps[i] = bubble.comparisons();
            bubbleSwaps[i] = bubble.swaps();
            // TODO
        }

        try (PrintWriter pw = new PrintWriter(new File("data.csv"))) {
            printData(pw, "bubble", bubbleComps, bubbleSwaps);
            // TODO: write data for other algorithms
        } catch (FileNotFoundException e) {
            // TODO: give yourself a helpful error message
        }
    }

    // You could just copy-paste the print code a bunch of times in the try
    // block, but a function like this will make it less tedious.
    static void printData(PrintWriter pw, String name, int[] comparisons, int[] swaps) {
        pw.println(name + ",,,,,,");
        pw.print("comparisons,");
        for (int i : comparisons) {
            pw.print(i + ",");
        }
        pw.println();
        pw.print("swaps,");
        for (int i : swaps) {
            pw.print(i + ",");
        }
    }
}
