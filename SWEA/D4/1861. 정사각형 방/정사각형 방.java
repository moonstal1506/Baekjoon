import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N, maxDistance, roomNum, distance;
    static int[][] map;

    //테스트 케이스의 수 T
    //처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지
    //이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            maxDistance = 0;
            roomNum = Integer.MAX_VALUE;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(i, j);

                }
            }

            System.out.println("#" + tc + " " + roomNum + " " + maxDistance);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        int cnt = 1;
        while (!Q.isEmpty()) {
            int cx = Q.poll();
            int cy = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (map[nx][ny] == map[cx][cy] + 1) {
                    Q.add(nx);
                    Q.add(ny);
                    cnt++;
                }
            }
        }

        if (maxDistance < cnt) {
            maxDistance = cnt;
            roomNum = map[x][y];
        }

        if (maxDistance == cnt) {
            roomNum = Math.min(roomNum, map[x][y]);
        }
    }

}