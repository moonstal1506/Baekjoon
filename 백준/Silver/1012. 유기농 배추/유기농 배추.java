import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;
    static int m, n, k;

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[m][n];
            int answer=0;

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }

            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (arr[a][b] == 1) {
                        answer++;
                        dfs(a, b);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int x, int y) {
        arr[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0<=nx&&nx<m && 0<=ny&&ny<n && arr[nx][ny]==1){
                dfs(nx,ny);
            }
        }
    }
}

