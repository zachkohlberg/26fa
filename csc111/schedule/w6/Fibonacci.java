public class Fib {
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);

        // time the whole sequence
        long start = System.nanoTime();

        for (long n = 1; n <= count; n++) {
            long fibN = fib(n);
            System.out.printf("fib(%d) = %d\n", n, fibN);
        }

        long end = System.nanoTime();
        long elapsed = end - start;
        System.out.printf(
                "Took %d nanoseconds to calculate the first %d fibonacci numbers.\n",
                elapsed, count);
    }

    // TODO: fibonacci implementations

    // NOTE: as with factorial, overflow will occur quickly
    //
    // - use long for N up to the 80s
    // - use BigInteger for N in the 90s and higher
    // - demonstrate overflow with fast version
    // - could compare speed of long and BigInteger
}
