public class UnsortedIntArrayList implements UnorderedIntList {
    private int[] data;
    private int size;

    public UnsortedIntArrayList(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int capacity() {
        return data.length;
    }

    public int size() {
        return size;
    }

    public boolean add(int element) {
        if (size() >= capacity()) {
            return false;
        }

        data[size] = element;
        size += 1;

        return true;
    }

    public boolean remove(int element) {
        for (int i = 0; i < size(); i++) {
            if (data[i] == element) {
                size -= 1;
                data[i] = data[size];

                return true;
            }
        }

        return false;
    }

    public boolean contains(int element) {
        for (int i = 0; i < size(); i++) {
            if (data[i] == element) {
                return true;
            }
        }

        return false;
    }

    public void clear() {
        size = 0;
    }

    public int[] toArray() {
        int[] array = new int[size()];

        for (int i = 0; i < size(); i++) {
            array[i] = data[i];
        }

        return array;
    }
}
