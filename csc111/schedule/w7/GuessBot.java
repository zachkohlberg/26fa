/**
 * Implements an algorithm to guess a secret number. This starter version performs a linear search,
 * but you can improve it by switching to a binary search.
 *
 * @author Zach Kohlberg
 * @author YOU, after you rewrite this!
 */
public class GuessBot {
    public static void main(String[] args) {
        // choose a secret number from 1 to 1 billion
        SecretNumber secret = new SecretNumber();

        // shows what secret number will tell us before guessing
        System.out.println("Secret number:");
        System.out.println(secret);

        // use some algorithm to figure out the number
        int guess = findSecret(secret);

        // guess the number once we've figured it out
        secret.guessSecret(guess);

        // shows whether we guessed correctly
        // we will ALWAYS guess correctly if we correctly implemented our algorithm
        // we want to guess correctly with the fewest possible queries
        System.out.println("Secret number:");
        System.out.println(secret);
    }

    static int findSecret(SecretNumber secret) {
        // TODO: replace this inefficient linear search strategy (which takes about 500 million
        // queries on average) with a much faster binary search

        // try every possible value until we find the number
        for (int i = SecretNumber.MIN_VALUE; i <= SecretNumber.MAX_VALUE; ++i) {
            // we started with the lowest possible value, so we've reached the secret number as soon
            // as the secret isn't greater than our value
            if (!secret.isGreaterThan(i)) {
                return i;
            }
        }

        // the secret number always exists, and we should never fail to find it if we implement our
        // algorithm correctly
        throw new RuntimeException(
                "Our algorithm didn't find the secret. This means our code is wrong!");
    }
}
