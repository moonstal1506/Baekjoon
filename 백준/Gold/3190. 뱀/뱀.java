import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        HashMap<Integer, String> move = new HashMap<>();
        List<int[]> snake = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x][y] = 1;
        }
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            move.put(sec, dir);
        }

        int x = 0;
        int y = 0;
        int time = 0;
        int d = 0;
        snake.add(new int[]{0, 0});

        while (true) {
            time++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isFinish(n, snake, nx, ny)) break;

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new int[]{nx, ny});
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            if (move.containsKey(time)) {
                if (move.get(time).equals("D")) {
                    d += 1;
                    if (d == 4)
                        d = 0;
                } else {
                    d -= 1;
                    if (d == -1)
                        d = 3;
                }
            }

            x = nx;
            y = ny;
        }

        System.out.println(time);
    }

    private static boolean isFinish(int n, List<int[]> snake, int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            return true;
        }

        for (int i = 0; i < snake.size(); i++) {
            int[] cur = snake.get(i);
            if (nx == cur[0] && ny == cur[1]) {
                return true;
            }
        }
        return false;
    }
}