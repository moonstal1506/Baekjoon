import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[n + 1];
        boolean[][] arr = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVisited[1] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer num = q.poll();
                for (int j = 1; j <= n; j++) {
                    if (arr[num][j] && !isVisited[j]) {
                        isVisited[j] = true;
                        q.add(j);
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

}