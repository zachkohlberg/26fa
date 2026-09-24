public class SortedIntArrayList implements UnorderedIntList {
    private int[] data;
    private int size;

    public SortedIntArrayList(int capacity) {
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

        int i = size();
        while (i > 0 && data[i - 1] > element) {
            data[i] = data[i - 1];
            i -= 1;
        }

        data[i] = element;
        size += 1;
        return true;
    }

    public boolean remove(int element) {
        int index = indexOf(element);

        if (index == -1) {
            return false;
        }

        size -= 1;

        for (int i = index; i < size(); i++) {
            data[i] = data[i + 1];
        }

        return true;
    }

    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    // binary search
    private int indexOf(int element) {
        int min = 0, max = size - 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (data[mid] < element) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        if (data[min] == element) {
            return min;
        } else {
            return -1;
        }
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
