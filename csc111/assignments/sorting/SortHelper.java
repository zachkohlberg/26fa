import java.util.Random;

public class SortHelper {
    private static Random r = new Random();

    public static void setSeed(long seed) {
        r.setSeed(seed);
    }

    public static int[] randomArray(int length) {
        int bound = length / 2;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt(bound);
        }
        return array;
    }

    public static int[] copy(int[] original) {
        int[] array = new int[original.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = original[i];
        }
        return array;
    }
}
