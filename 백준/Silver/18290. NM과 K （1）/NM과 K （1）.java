import java.util.Scanner;

public class Main {
    static int[][] arr = new int[10][10];
    static boolean[][] check = new boolean[10][10];
    static int n, m, k;
    static int ans = Integer.MIN_VALUE;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void dfs(int px, int py, int cnt, int sum) {
        if (cnt == k) {
            if (ans < sum) ans = sum;
            return;
        }
        for (int x=px; x<n; x++) {
            for (int y=(x == px ? py : 0); y<m; y++) {
                if (check[x][y]) continue;
                boolean flag = true;
                for (int i=0; i<4; i++) {
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (check[nx][ny]) flag = false;
                    }
                }
                if (flag) {
                    check[x][y] = true;
                    dfs(x, y, cnt+1, sum+ arr[x][y]);
                    check[x][y] = false;
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0, 0, 0);
        System.out.println(ans);
    }
}