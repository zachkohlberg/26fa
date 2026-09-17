public interface UnorderedIntList {
    int capacity();

    int size();

    boolean add(int element);

    boolean remove(int element);

    boolean contains(int element);

    void clear();

    int[] toArray();
}
