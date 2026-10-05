import java.io.File;
import java.io.FileNotFoundException;

public class MazeTest {
    public static void main(String[] args) {
        Maze maze1 = new Maze(4, 13);
        for (int i = 0; i < 26; i++) {
            maze1.set(i / 13, i % 13, (char) ('a' + i));
            maze1.set(2 + i / 13, i % 13, (char) ('A' + i));
        }
        test(maze1);
        // the for loop above should result in the following maze:
        //
        // abcdefghijklm
        // nopqrstuvwxyz
        // ABCDEFGHIJKLM
        // NOPQRSTUVWXYZ

        try {
            Maze maze2 = new Maze(new File("maze.txt"));
            test(maze2);
            // the maze should look exactly as shown in the file, minus the dimensions and comments
        } catch (FileNotFoundException e) {
            System.out.println(
                    "ERROR: You're missing maze.txt! Can't test whether the file constructor"
                            + " works.");
        }
    }

    public static void test(Maze m) {
        int rows = m.getRows();
        int cols = m.getCols();
        System.out.printf("%dx%d maze:\n%s\n\n", rows, cols, m);
        System.out.printf(
                "Corners:\n%s%s\n%s%s\n\n",
                m.get(0, 0), m.get(rows - 1, 0), m.get(0, cols - 1), m.get(rows - 1, cols - 1));
        // should say yes
        checkInBounds(m, 0, 0);
        checkInBounds(m, rows / 2, cols / 2);
        // should say no
        checkOutOfBounds(m, -1, 0);
        checkOutOfBounds(m, 0, -1);
        checkOutOfBounds(m, 0, cols);
        checkOutOfBounds(m, rows, 0);
        checkOutOfBounds(m, rows, cols);
    }

    public static void checkInBounds(Maze m, int row, int col) {
        if (m.inBounds(row, col)) {
            System.out.printf("CORRECT: r%dc%d is in bounds\n", row, col);
        } else {
            System.out.printf("  ERROR: r%dc%d is out of bounds\n", row, col);
        }
    }

    public static void checkOutOfBounds(Maze m, int row, int col) {
        if (m.inBounds(row, col)) {
            System.out.printf("  ERROR: r%dc%d is in bounds\n", row, col);
        } else {
            System.out.printf("CORRECT: r%dc%d is out of bounds\n", row, col);
        }
    }
}
