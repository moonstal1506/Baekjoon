import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max, x, y = 0;
    static int[][] map;
    static int[][] newMap;
    static List<Point> points;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new int[x][y];
        newMap = new int[x][y];
        points = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    points.add(new Point(i, j));
                }
            }
        }

        //벽 세울 수 있는 곳 3개 골라서 벽세우기(1,2 아닌곳으로)
        //0인곳 리스트 담고 조합으로 3개 선택하고 1로 바꿔줘 - 빠져나올때 다시 0 복구
        combi(0, 0);
        System.out.println(max);
    }

    private static void combi(int cnt, int start) {
        if (cnt == 3) {
            //바이러스 퍼트리기
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    newMap[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (newMap[i][j] == 2) {
                        dfs(i, j);
                    }
                }
            }

            //0인곳 개수 구하기
            int safe = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (newMap[i][j] == 0) {
                        safe++;
                    }
                }
            }
            max = Math.max(max, safe);
            return;
        }

        for (int i = start; i < points.size(); i++) {
            Point point = points.get(i);
            map[point.x][point.y] = 1;
            combi(cnt + 1, i + 1);
            map[point.x][point.y] = 0;
        }
    }

    private static void dfs(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            //현재가 2이고 다음거가 0일때 돌아
            if (0 <= nx && nx < x && 0 <= ny && ny < y && newMap[nx][ny] == 0) {
                newMap[nx][ny] = 2;
                dfs(nx, ny);
            }
        }
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}