import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static int[][] isVisited;
    static int n;
    static int max = 1;

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        isVisited = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }

        System.out.println(max);
    }

    private static int dfs(int x, int y) {
        if (isVisited[x][y] != 0) {
            return isVisited[x][y];
        }
        isVisited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inside(nx, ny) || arr[x][y] >= arr[nx][ny]) {
                continue;
            }
            isVisited[x][y] = Math.max(isVisited[x][y], dfs(nx, ny) + 1);
        }
        return isVisited[x][y];
    }

    private static boolean inside(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
}