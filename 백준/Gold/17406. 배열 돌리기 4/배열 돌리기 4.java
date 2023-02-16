import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int[][] command;
    static int[] permutation;
    static boolean[] isVisited;
    static int answer = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        command = new int[K][3];
        permutation = new int[K];
        isVisited = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            command[i][0] = Integer.parseInt(st.nextToken())-1;
            command[i][1] = Integer.parseInt(st.nextToken())-1;
            command[i][2] = Integer.parseInt(st.nextToken());
        }

        permutation(0);
        System.out.println(answer);

    }

    private static void permutation(int cnt) {
        if (cnt == K) {
            int[][] movedArr = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    movedArr[i][j] = arr[i][j];
                }
            }
            for (int idx : permutation) {
                move(command[idx][0], command[idx][1], command[idx][2],movedArr);
            }
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += movedArr[i][j];
                }
                answer = Math.min(answer, sum);
            }
        }

        for (int i = 0; i < K; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            permutation[cnt] = i;
            permutation(cnt + 1);
            isVisited[i] = false;
        }
    }

    private static void move(int r, int c, int s, int[][] movedArr) {
        int sx = r - s;
        int sy = c - s;
        int ex = r + s;
        int ey = c + s;

        for (int i = 0; i < s; i++) {
            int tmp = movedArr[sx][sy];
            int x = sx;
            int y = sy;
            int d = 0;

            while (d < 4) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                //방향바꾸기
                if (nx < sx || nx > ex || ny < sy || ny > ey) {
                    d++;
                    continue;
                }

                //다음꺼
                movedArr[x][y] = movedArr[nx][ny];
                x = nx;
                y = ny;
            }

            movedArr[sx][sy + 1] = tmp;
            sx++;
            sy++;
            ex--;
            ey--;
        }
    }
}

