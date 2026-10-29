public class StringIntPair {
    public String v1;
    public int v2;

    public StringIntPair(String v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public String toString() {
        return String.format("(%s, %s)", v1, v2);
    }
}
