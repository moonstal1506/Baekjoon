import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 1));
        q.add(new Node(n, 2));
        q.add(new Node(n - 1, 1));
        q.add(new Node(n - 1, 2));

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] visit = new boolean[n + 1][n + 1];

            //구름 이동 물증가
            for (Node node : q) {
                node.x = (n + node.x + dx[d] * (k % n) - 1) % n + 1;
                node.y = (n + node.y + dy[d] * (k % n) - 1) % n + 1;
                arr[node.x][node.y]++;
                visit[node.x][node.y] = true;
            }

            //대각선 물복사
            while (!q.isEmpty()) {
                int cnt = 0;
                Node node = q.poll();
                for (int j = 2; j <= 8; j += 2) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx < 1 || ny < 1 || nx > n || ny > n || arr[nx][ny] == 0) {
                        continue;
                    }
                    cnt++;
                }
                arr[node.x][node.y] += cnt;
            }

            //구름생김 -2
            for (int z = 1; z <= n; z++) {
                for (int j = 1; j <= n; j++) {
                    if (!visit[z][j] && arr[z][j] >= 2) {
                        arr[z][j] -= 2;
                        q.add(new Node(z, j));
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }

}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}