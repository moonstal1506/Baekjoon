import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //치즈개수가 0일때까지
    //지워진 치즈개수 카운트해서 저장
    //가장자리만 지워
    //처음만난 0의 다음에 오는 1은 가장자리임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static boolean[][] isVisited;
    static int n, m, lastCheese, cheese, time;

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    cheese++;
                }
            }
        }
        while (cheese != 0) {
            time++;
            lastCheese = cheese;
            reset();
            bfs();
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }

    private static void reset() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisited[i][j] = false;
            }
        }
    }

    private static void bfs() {
        isVisited[0][0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        int melt = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || isVisited[nx][ny]) {
                    continue;
                }
                isVisited[nx][ny] = true;
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 0;
                    melt++;
                    continue;
                }

                if (arr[nx][ny] == 0) {
                    q.add(nx);
                    q.add(ny);
                }
            }
        }
        cheese -= melt;
    }
}