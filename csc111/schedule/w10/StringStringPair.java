public class StringStringPair {
    public String v1, v2;

    public StringStringPair(String v1, String v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public String toString() {
        return String.format("(%s, %s)", v1, v2);
    }
}
