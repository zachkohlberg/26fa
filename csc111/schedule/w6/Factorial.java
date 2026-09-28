import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        System.out.printf("factorialIter(%d) = %d\n", n, factorialIter(n));
        System.out.printf(
                "factorialIterBig(%d) = %s\n", n, factorialIterBig(new BigInteger("" + n)));
        System.out.printf("factorialRec(%d) = %d\n", n, factorialRec(n));
        System.out.printf("factorialRecBig(%d) = %s\n", n, factorialRecBig(new BigInteger("" + n)));
    }

    // NOTE: factorial will quickly overflow an int
    //
    // - long will work until around n=20, test this
    // - BigInteger can handle arbitrarily large numbers, but it's slower

    public static long factorialIter(long n) {
        // TODO
    }

    public static BigInteger factorialIterBig(BigInteger n) {
        // TODO
    }

    public static long factorialRec(long n) {
        // TODO
    }

    public static BigInteger factorialRecBig(BigInteger n) {
        // TODO
    }
}
