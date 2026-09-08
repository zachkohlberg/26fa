public class Sum {
    public static void main(String[] args) {
        // note: this program uses command line args for input, so no scanner

        int sum = 0;

        for (int i = 0; i < args.length; i++) {
            try {
                int n = Integer.parseInt(args[i]);
                sum += n;
                System.out.printf("Adding %d, sum is now %d.\n", n, sum);
            } catch (NumberFormatException e) {
                System.out.printf("Skipping \"%s\" because it's not an integer.\n", args[i]);
            }
        }

        System.out.printf("Finished! Final sum is %d.\n", sum);
    }
}
