import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;
    static int n;
    static int answer=0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==1){
                    answer=1;
                    arr[i][j]=0;
                    dfs(i,j);
                    list.add(answer);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0<=nx&&nx<n && 0<=ny&&ny<n && arr[nx][ny]==1){
                answer++;
                arr[nx][ny]=0;
                dfs(nx,ny);
            }
        }
    }
}
