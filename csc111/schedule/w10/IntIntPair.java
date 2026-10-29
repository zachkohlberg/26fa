public class IntIntPair {
    public int v1, v2;

    public IntIntPair(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public String toString() {
        return String.format("(%s, %s)", v1, v2);
    }
}
