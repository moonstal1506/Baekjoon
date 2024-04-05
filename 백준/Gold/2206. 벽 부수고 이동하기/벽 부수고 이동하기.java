import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }
        bfs();
    }

    private static void bfs() {
        int[][][] isVisited = new int[2][n][m];//0-벽을 부수지 않고 이동한 경우, 1-벽을 부수고 이동한 경우
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        q.add(0);
        isVisited[0][0][0] = 1;
        while (!q.isEmpty()) {
            int w = q.poll();
            int x = q.poll();
            int y = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 > nx || 0 > ny || nx >= n || ny >= m) {
                    continue;
                }

                // 벽을 부수지 않고 이동하는 경우
                if (arr[nx][ny] == 0 && isVisited[w][nx][ny] == 0) {
                    q.add(w);
                    q.add(nx);
                    q.add(ny);
                    isVisited[w][nx][ny] = isVisited[w][x][y] + 1;
                    if (nx == n - 1 && ny == m - 1) {
                        System.out.println(isVisited[w][nx][ny]);
                        return;
                    }
                    continue;
                }

                // 벽을 부수고 이동하는 경우
                if (arr[nx][ny] == 1 && w == 0 && isVisited[1][nx][ny] == 0) {
                    q.add(1);
                    q.add(nx);
                    q.add(ny);
                    isVisited[1][nx][ny] = isVisited[0][x][y] + 1;
                    if (nx == n - 1 && ny == m - 1) {
                        System.out.println(isVisited[1][nx][ny]);
                        return;
                    }
                }
            }
        }
        // 도착지점에 도달하지 못한 경우
        System.out.println(-1);
    }
}