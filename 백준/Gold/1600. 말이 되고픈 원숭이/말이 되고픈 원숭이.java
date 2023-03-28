import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] mx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] my = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[][] arr;
    static boolean[][][] visited;
    static int n, y, x;

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[x][y];
        visited = new boolean[x][y][n + 1];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs(new Monkey(0, 0, n, 0)));
    }

    private static int bfs(Monkey monkey) {
        visited[0][0][n] = true;
        Queue<Monkey> q = new LinkedList<>();
        q.add(monkey);

        while (!q.isEmpty()) {
            Monkey cur = q.poll();
            if (cur.x == x - 1 && cur.y == y - 1) {
                return cur.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= x || ny >= y)
                    continue;
                if (visited[nx][ny][cur.n] == true)
                    continue;
                if (arr[nx][ny] == 1) {
                    continue;
                }
                visited[nx][ny][cur.n] = true;
                q.offer(new Monkey(nx, ny, cur.n, cur.count + 1));
            }

            if (cur.n > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + mx[i];
                    int ny = cur.y + my[i];

                    if (nx < 0 || ny < 0 || nx >= x || ny >= y)
                        continue;
                    if (visited[nx][ny][cur.n-1] == true)
                        continue;
                    if (arr[nx][ny] == 1) {
                        continue;

                    }
                    visited[nx][ny][cur.n - 1] = true;
                    q.offer(new Monkey(nx, ny, cur.n -1,cur.count +1));
                }
            }
        }
        return -1;
    }
}

class Monkey {
    int x;
    int y;
    int n;
    int count;

    public Monkey(int x, int y, int n, int count) {
        super();
        this.x = x;
        this.y = y;
        this.n = n;
        this.count = count;
    }
}