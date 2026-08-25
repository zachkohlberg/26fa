import java.io.File;
import java.io.FileNotFoundException;

public class MazeTest {
    public static void main(String[] args) {
        Maze maze1 = new Maze(6, 6);
        for (int i = 0; i < 36; i++) {
            if (i < 10) {
                maze1.set((char) ('0' + i), i % 6, i / 6);
            } else {
                maze1.set((char) ('A' + i - 10), i % 6, i / 6);
            }
        }
        test(maze1);
        // the for loop above should result in the following maze
        // 012345
        // 6789AB
        // CDEFGH
        // IJKLMN
        // OPQRST
        // UVWXYZ

        char[][] data =
                new char[][] {
                    new char[] {'X', 'S', 'X', 'X', 'X', 'X', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', 'X', 'X', 'X', 'X', ' ', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', ' ', 'X', 'X', 'X', 'X', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', 'X', 'X', 'X', 'X', ' ', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', ' ', 'X', 'X', 'X', 'X', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', 'X', 'X', 'X', 'X', ' ', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', ' ', 'X', 'X', 'X', 'X', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', 'X', 'X', 'X', 'X', ' ', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', ' ', 'X', 'X', 'X', 'X', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', 'X', 'X', 'X', 'X', ' ', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', ' ', 'X', 'X', 'X', 'X', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', 'X', 'X', 'X', 'X', ' ', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', ' ', 'X', 'X', 'X', 'X', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', 'X', 'X', 'X', 'X', ' ', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', ' ', 'X', 'X', 'X', 'X', 'X'},
                    new char[] {'X', ' ', ' ', ' ', ' ', ' ', 'X'},
                    new char[] {'X', 'X', 'X', 'X', 'X', 'F', 'X'}
                };
        // The char array above represents the following maze:
        // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        // S X   X   X   X   X   X   X   X
        // X X X X X X X X X X X X X X X X
        // X X X X X X X X X X X X X X X X
        // X X X X X X X X X X X X X X X X
        // X   X   X   X   X   X   X   X F
        // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        Maze maze2 = new Maze(data);
        test(maze2);

        try {
            Maze maze3 = new Maze(new File("maze.txt"));
            test(maze3);
            // the maze should look exactly as shown in the file, minus the comments
        } catch (FileNotFoundException e) {
            System.out.println(
                    "ERROR: You're missing maze.txt! Can't test whether the file constructor"
                            + " works.");
        }
    }

    public static void test(Maze m) {
        int w = m.getWidth();
        int h = m.getHeight();
        System.out.printf("%dx%d maze:\n%s\n\n", w, h, m);
        System.out.printf(
                "Corners:\n%s%s\n%s%s\n\n",
                m.get(0, 0), m.get(w - 1, 0), m.get(0, h - 1), m.get(w - 1, h - 1));
        // should say yes
        checkBounds(m, 0, 0);
        checkBounds(m, w / 2, h / 2);
        // should say no
        checkBounds(m, -1, 0);
        checkBounds(m, 0, -1);
        checkBounds(m, 0, h);
        checkBounds(m, w, 0);
        checkBounds(m, w, h);
    }

    public static void checkBounds(Maze m, int x, int y) {
        System.out.printf("Is (%d, %d) in bounds? %s\n", x, y, m.inBounds(x, y) ? "yes" : "no");
    }
}
