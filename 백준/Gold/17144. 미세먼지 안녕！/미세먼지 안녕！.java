import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, T, p1, p2;
    static int[][] map;
    static int[][] newMap;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                p1 = i;
                p2 = i + 1;
                break;
            }
        }

        for (int i = 0; i < T; i++) {
            //확산
            map = diffuse();

            //공기청정기 작동
            operate();
        }

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                cnt += map[i][j];
            }
        }
        System.out.println(cnt + 2);
    }

    private static int[][] diffuse() {
        newMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    newMap[i][j] = -1;
                    continue;
                }

                //현재 미세먼지
                newMap[i][j] += map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) {
                        continue;
                    }
                    //퍼트리기
                    newMap[nx][ny] += map[i][j] / 5;
                    //현재꺼 감소
                    newMap[i][j] -= map[i][j] / 5;
                }
            }
        }
        return newMap;
    }

    private static void operate() {
        //상단
        //아래로 이동 -1부분 빼고, 0빼고
        for (int i = p1 - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }

        //왼쪽 이동
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }

        //위로 이동
        for (int i = 0; i < p1; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }

        //오른쪽으로 이동
        for (int i = C - 1; i > 1; i--) {
            map[p1][i] = map[p1][i - 1];
        }

        map[p1][1] = 0;

        //하단
        //위로
        for (int i = p2 + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }

        //왼쪽으로
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }

        //아래로
        for (int i = R - 1; i > p2; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }

        //오른쪽으로
        for (int i = C - 1; i > 1; i--) {
            map[p2][i] = map[p2][i - 1];
        }

        map[p2][1] = 0;
    }

}