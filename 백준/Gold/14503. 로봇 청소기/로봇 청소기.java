import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt, n, m;
    static int[][] map;

    // 북동남서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        s = br.readLine();
        st = new StringTokenizer(s);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        dfs(x, y, direction);
        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int direction) {
        // 현재 위치를 청소한다.
        if (map[x][y] == 0) {
            map[x][y] = 2; // 청소한 곳은 2로 표시
            cnt++;
        }

        // 네 방향 모두 청소가 되어있거나 벽인 경우
        if (map[x - 1][y] != 0 && map[x + 1][y] != 0 && map[x][y - 1] != 0 && map[x][y + 1] != 0) {
            // 뒤쪽 방향이 벽이 아닌 경우 후진한다.
            int backDirection = (direction + 2) % 4;
            int nx = x + dx[backDirection];
            int ny = y + dy[backDirection];
            if (map[nx][ny] != 1) {
                dfs(nx, ny, direction);
                return;
            } else {
                // 후진할 수 없으면 종료
                return;
            }
        }

        // 현재 방향에서 왼쪽 방향부터 탐색
        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 청소할 곳이 존재하면 그 방향으로 회전하고 한 칸을 전진하여 청소한다.
            if (map[nx][ny] == 0) {
                dfs(nx, ny, direction);
                return;
            }
        }
    }
}