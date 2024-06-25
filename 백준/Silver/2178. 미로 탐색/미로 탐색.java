import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(n, m));
    }

    private static int bfs(int n, int m) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        int cnt = 0;

        while (!q.isEmpty()) {
            cnt++;
            int size = q.size() / 2;
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                int y = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + x;
                    int ny = dy[j] + y;

                    if (nx == n - 1 && ny == m - 1) {
                        return cnt + 1;
                    }

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 0) {
                        continue;
                    }
                    arr[nx][ny] = 0;
                    q.add(nx);
                    q.add(ny);
                }
            }
        }
        return cnt;
    }
}