import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int c;
    static int r;
    static int h;
    static int[][][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dz = {1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][r][c];
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r; j++) {
                s = br.readLine();
                st = new StringTokenizer(s);
                for (int k = 0; k < c; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 0) {
                        cnt++;
                        continue;
                    }
                    if (arr[i][j][k] == 1) {
                        q.add(i);
                        q.add(j);
                        q.add(k);
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        int day = 0;
        while (true) {
            int size = q.size() / 3;
            for (int z = 0; z < size; z++) {
                int ch = q.poll();
                int cx = q.poll();
                int cy = q.poll();

                //4방향
                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        continue;
                    }
                    if (arr[ch][nx][ny] == 0) {
                        arr[ch][nx][ny] = 1;
                        q.add(ch);
                        q.add(nx);
                        q.add(ny);
                    }
                }

                //위아래
                for (int i = 0; i < 2; i++) {
                    int nh = ch + dz[i];
                    if (nh < 0 || nh >= h) {
                        continue;
                    }
                    if (arr[nh][cx][cy] == 0) {
                        arr[nh][cx][cy] = 1;
                        q.add(nh);
                        q.add(cx);
                        q.add(cy);
                    }
                }
            }

            if (q.isEmpty()) {
                break;
            }

            day++;
        }

        cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (arr[i][j][k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        if (cnt > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(day);
    }

}