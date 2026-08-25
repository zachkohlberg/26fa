import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author YOUR NAME HERE
 */
public class SortingExperiment {
    public static void main(String[] args) {
        // TODO: SortHelper.setSeed(?);

        // arrays to store our data
        int[] bubbleComps = new int[5];

        // run the experiment
        for (int i = 0; i < 5; i++) {
            int length = (i + 1) * 10_000;

            // identical random arrays for each algorithm
            int[] bubbleArray = SortHelper.randomArray(length);
            int[] selectionArray = SortHelper.copy(bubbleArray);

            // instantiate algorithms
            BubbleSort bubble = new BubbleSort();

            // sort
            bubble.sort(bubbleArray, 0, bubbleArray.length);

            // record results
            bubbleComps[i] = bubble.getComparisons();
            // TODO: don't forget swaps!
        }

        try (PrintWriter pw = new PrintWriter(new File("data.csv"))) {
            printData(pw, "bubble", bubbleComps, null);
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
        // TODO: print swaps
    }
}
