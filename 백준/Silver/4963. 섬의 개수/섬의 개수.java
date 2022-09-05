import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            m =sc.nextInt();
            n =sc.nextInt();
            if (n==0 && m==0) break;
            arr = new int[n][m];
            int answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        arr[i][j] = 0;
                        answer++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                dfs(nx,ny);
            }
        }
    }
}
