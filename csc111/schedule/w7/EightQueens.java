public class EightQueens {
    public static void main(String[] args) {
        int[][] board = new int[ROWS][COLS];

        // demonstrate the print method (remove this)
        board[2][1] = QUEEN;
        printBoard(board);

        // TODO: demonstrate placeQueens method and print the solution
    }

    // constants for board spaces
    static final int QUEEN = -1;
    static final int SAFE = 0;

    // constants for board dimensions, which we will assume the array conforms to
    static final int ROWS = 8, COLS = 8;

    // this function will attempt to place a queen in each column starting at
    // col and ending at COLS - 1 so that no queen attacks any other queen, then
    // returns whether it was able to do so
    //
    // this function is also responsible for cleaning up any unsuccessful queen
    // placements; this means if we return false, then the board must be in
    // exactly the same state as when this function call began
    //
    // the board is represented as an 8x8 array of integers
    //
    // - -1 indicates that a queen occupies that space
    // - 0 indicates that the space is unoccupied and safe from attack
    // - positive integers indicate how many queens are attacking that space
    //
    // we'll make several assumptions about the board in our code
    //
    // - the array is 8x8
    // - every column less than col already has a queen placed
    // - every column from col to COLS - 1 does not contain a queen
    // - given the existing queen placements, every unoccupied space correctly
    //   indicates how many queens are attacking it
    //
    // we could make a class for the board that encapsulates the array and
    // guarantees the above invariants, but I think that's excessive for this
    // exercise, obfuscates what we're actually doing to the array, and focuses
    // too much on OOP
    public static boolean placeQueens(int[][] board, int col) {
        // TODO
        return false; // temp, remove this
    }

    // update board state after placing a queen
    public static void attack(int[][] board, int row, int col) {
        // TODO
    }

    // update board state after undoing a queen placement
    public static void unattack(int[][] board, int row, int col) {
        // TODO
    }

    // print the board as displayed in the example image (a little overkill, but
    // it's fun to display stuff in ascii and this makes for a nice example if
    // you want to do something similar)
    //
    // this method could be made far more efficient, but I want to break down the
    // process clearly so that it works better as an example, and it's not called
    // frequently enough for the speed to matter
    //
    // expected output for a queen on r2c1:
    //
    //    0 1 2 3 4 5 6 7
    //   +-+-+-+-+-+-+-+-+
    // 0 | | | | | | | | |
    //   +-+-+-+-+-+-+-+-+
    // 1 | | | | | | | | |
    //   +-+-+-+-+-+-+-+-+
    // 2 | |Q| | | | | | |
    //   +-+-+-+-+-+-+-+-+
    // 3 | | | | | | | | |
    //   +-+-+-+-+-+-+-+-+
    // 4 | | | | | | | | |
    //   +-+-+-+-+-+-+-+-+
    // 5 | | | | | | | | |
    //   +-+-+-+-+-+-+-+-+
    // 6 | | | | | | | | |
    //   +-+-+-+-+-+-+-+-+
    // 7 | | | | | | | | |
    //   +-+-+-+-+-+-+-+-+
    public static void printBoard(int[][] board) {
        // column header

        // padding
        System.out.print("  ");
        // column numbers
        for (int col = 0; col < COLS; col++) {
            System.out.print(" " + col);
        }
        // end the column header
        System.out.println();

        // row separator could be hard-coded, but it's easy to generate based on
        // the number of columns and makes this code easier to adapt to other
        // board sizes

        // padding and first +
        String rowSeparator = "  +";
        for (int col = 0; col < COLS; col++) {
            rowSeparator += "-+";
        }

        // first row separator for the top of the board
        System.out.println(rowSeparator);

        // print each row with a separator beneath it

        for (int row = 0; row < ROWS; row++) {
            // row label and left wall
            System.out.print(row + " |");

            // print each cell in the row
            for (int col = 0; col < COLS; col++) {
                // we can modify this to show which spaces are attacked, but I
                // think we'd usually prefer to just see the queen placements,
                // which would make a bunch of numbers or x's distracting
                if (board[row][col] == QUEEN) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }

            // end the row
            System.out.println();

            // row separator before the next row
            System.out.println(rowSeparator);
        }

        // that's it, we're done!
    }

    // some additional questions/exercises to consider after we finish this
    // program:
    //
    // - Are all of the changes we made to the board in the attack and unattack
    //   methods necessary? (hint: the answer is no, but what really matters is
    //   which changes are unnecessary and why)
    // - Try generalizing this function to work with a rectangular board of any
    //   size.
    // - How efficient is this algorithm? What size board do you think would
    //   take too long to search for a solution?
    // - Is recursion necessary? Could you implement this as an iterative
    //   algorithm without adding a stack?
}
