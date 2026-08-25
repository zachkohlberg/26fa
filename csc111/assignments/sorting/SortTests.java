import java.util.HashMap;

public class SortTests {
    // You can comment out the tests for any algorithms you've yet to implement.
    // Make sure your class names match the names used below and your sort
    // method has the correct name and parameters.
    public static void main(String[] args) {
        test("Bubble Sort", new BubbleSort()::sort);
        test("Selection Sort", new SelectionSort()::sort);
        test("Insertion Sort", new InsertionSort()::sort);
        test("Mergesort", new Mergesort()::sort);
        test("Quicksort", new Quicksort()::sort);
    }

    // Functional interface, allows me to pass the sort method to test and avoid
    // a ton of duplicate code. I'm not covering interfaces and any of Java's
    // functional programming features because the FP stuff is off-topic, SER120
    // should already cover interfaces, and covering interfaces properly would
    // take time that we probably don't have. If you're curious about how this
    // works, then I'd be happy to explain it during office hours.
    public static interface Sort {
        void sort(int[] array, int start, int end);
    }

    // Checks whether a sorting algorithm works correctly. This will throw an
    // exception if your sorting algorithm doesn't pass the test.
    public static void test(String name, Sort sort) {
        // sort an entire array
        int[] array = SortHelper.randomArray(1000);
        int[] original = SortHelper.copy(array);
        sort.sort(array, 0, 1000);
        // confirm the array is sorted
        assertSorted(array, 0, 1000);
        // confirm the array contains the same elements (ignores order)
        assertSameContents(array, original, 0, 1000);

        // sort part of an array
        array = SortHelper.randomArray(1000);
        original = SortHelper.copy(array);
        sort.sort(array, 500, 750);
        // confirm the 500-750 section of the array is sorted
        assertSorted(array, 500, 750);
        // confirm the 0-500 and 750-1000 sections of the array were not changed
        assertUnchanged(array, original, 0, 500);
        assertUnchanged(array, original, 750, 1000);
        // confirm the 500-750 section of the array contains the same elements
        // (ignores order)
        assertSameContents(array, original, 500, 750);

        System.out.printf("%s passed.\n", name);
    }

    // Throws an exception if the specified section of array isn't sorted.
    public static void assertSorted(int[] array, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (array[i - 1] > array[i]) {
                throw new RuntimeException(
                        String.format(
                                "array[%d] (%d) is greater than array[%d] (%d)",
                                i - 1, array[i - 1], i, array[i]));
            }
        }
    }

    // Throws an exception if the specified section of array differs in any way
    // from original.
    public static void assertUnchanged(int[] array, int[] original, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] != original[i]) {
                throw new RuntimeException(
                        String.format(
                                "array[%d] (%d) is not equal to original[%d] (%d)",
                                i, array[i], i, original[i]));
            }
        }
    }

    // Throws an exception if the specified section of array doesn't contain the
    // same elements as original. The order of the elements does not matter.
    public static void assertSameContents(int[] array, int[] original, int start, int end) {
        // The hash maps are used to track how many times each integer appears
        // in this section of array and original. We can't assume anything about
        // the order of these elements, so we count everything first and then
        // compare the counts.
        HashMap<Integer, Integer> arrayCounts = new HashMap<>(), originalCounts = new HashMap<>();

        for (int i = start; i < end; i++) {
            arrayCounts.put(array[i], arrayCounts.getOrDefault(array[i], 0) + 1);
            originalCounts.put(original[i], originalCounts.getOrDefault(original[i], 0) + 1);
        }

        if (!arrayCounts.equals(originalCounts)) {
            throw new RuntimeException("array and original don't contain the same set of elements");
        }
    }
}
