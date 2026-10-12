public interface Sort {
    int comparisons();

    int swaps();

    void sort(int[] array, int start, int end);
}
