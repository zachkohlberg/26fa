/**
 * You don't need to read this code, and you MUST NOT edit it. All of your changes should be made to
 * the GuessBot program. All you need to know about SecretNumber is the following:
 *
 * <ul>
 *   <li>Upon creation, it chooses a secret int from 1 to 1 billion.
 *   <li>You can call .isGreaterThan(x) to ask whether the secret int is greater than x.
 *   <li>You can call .guessSecret(x) ONLY ONCE to guess that the secret number is x.
 *   <li>It will only accept numbers from 1 to 1 billion.
 *   <li>Correct usage is demonstrated by GuessBot.java.
 * </ul>
 *
 * <p>I felt like using javadoc comments in this code, which is why you see some html tags. You can
 * use the javadoc program (included with your jdk installation) to generate a documentation website
 * for this class.
 *
 * @author Zach Kohlberg
 */
public class SecretNumber {
    /** Lowest number allowed. */
    public static final int MIN_VALUE = 1;

    /** Highest number allowed. */
    public static final int MAX_VALUE = 1_000_000_000;

    private static final int NULL_GUESS = MIN_VALUE - 1;

    private int number;
    private int guess;
    private int queryCount;

    public SecretNumber() {
        number = (int) (Math.random() * MAX_VALUE) + MIN_VALUE;
        guess = NULL_GUESS;
        queryCount = 0;
    }

    /**
     * Used to check whether the secret value is greater than another number. Only accepts numbers
     * between the min and max values, and only allowed before guessing.
     *
     * @param n the number to compare to the secret number
     * @return true if the secret number is greater than n and false if it is not
     */
    public boolean isGreaterThan(int n) {
        if (guess != NULL_GUESS) {
            throw new SecretNumberException("You must not query after guessing.");
        }

        if (n < MIN_VALUE || n > MAX_VALUE) {
            throw new SecretNumberException(
                    String.format(
                            "You must only use numbers from %d to %d.", MIN_VALUE, MAX_VALUE));
        }

        ++queryCount;

        return number > n;
    }

    /**
     * Used to guess the secret number. Can only be called once, and only accepts a number between
     * the min and max value. This method should not be called until your code has narrowed the
     * secret down to only one possibility.
     *
     * @param n the guess
     * @return true if the guess is correct and false if it is not
     */
    public boolean guessSecret(int n) {
        if (guess != NULL_GUESS) {
            throw new SecretNumberException("You must not guess more than once.");
        }

        if (n < MIN_VALUE || n > MAX_VALUE) {
            throw new SecretNumberException(
                    String.format(
                            "You must only use numbers from %d to %d.", MIN_VALUE, MAX_VALUE));
        }

        guess = n;

        return number == guess;
    }

    @Override
    public String toString() {
        if (guess == 0) {
            return String.format("Guess: NONE, Queries: %d, Number: SECRET", queryCount);
        } else {
            return String.format(
                    "YOU %s! Guess: %d, Queries: %d, Number: %d",
                    number == guess ? "WIN" : "LOSE", guess, queryCount, number);
        }
    }

    public static class SecretNumberException extends RuntimeException {
        public SecretNumberException(String msg) {
            super(msg);
        }
    }
}
