import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] arr;
    static boolean[] isVisited;
    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int cnt, int cost) {
        if (cnt == n && start == 0) {
            answer = Math.min(answer, cost);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isVisited[i] || arr[start][i] == 0) {
                continue;
            }
            isVisited[i] = true;
            dfs(i, cnt + 1, cost + arr[start][i]);
            isVisited[i] = false;
        }
    }
}