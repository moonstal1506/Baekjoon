import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] isVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                isVisited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || isVisited[nx][ny]) {
                continue;
            }

            if (cnt == 2) {
                isVisited[nx][ny] = true;
                dfs(x, y, cnt + 1, sum + arr[nx][ny]);
                isVisited[nx][ny] = false;
            }

            isVisited[nx][ny] = true;
            dfs(nx, ny, cnt + 1, sum + arr[nx][ny]);
            isVisited[nx][ny] = false;
        }
    }

}