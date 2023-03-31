import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
    }

    static void bfs(int x, int y) {
        if (y > 8) {
            bfs(x + 1, 0);
            return;
        }

        if (x > 8) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (map[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    map[x][y] = i;
                    bfs(x, y + 1);
                }
            }
            map[x][y] = 0;
            return;
        }

        bfs(x, y + 1);
    }

    static boolean check(int x, int y, int num) {
        int X = x / 3 * 3;
        int Y = y / 3 * 3;
        for (int i = X; i < X + 3; i++) {
            for (int j = Y; j < Y + 3; j++) {
                if (map[i][j] == num)
                    return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num)
                return false;
        }

        for (int j = 0; j < 9; j++) {
            if (map[j][y] == num) {
                return false;
            }
        }

        return true;
    }
}
