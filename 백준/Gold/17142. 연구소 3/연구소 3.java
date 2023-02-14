import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int blank;
    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] combi;
    static boolean[][] isVisited;
    static ArrayList<Virus> list = new ArrayList<Virus>();
    static Queue<Virus> q = new LinkedList<Virus>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // 0은 빈 칸, 1은 벽, 2는 바이러스의 위치
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        combi = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 2) {
                    list.add(new Virus(i, j));
                }
                if (input == 0) {
                    blank++;
                }
                arr[i][j] = input;
            }
        }
        if(blank==0){
            System.out.println(0);
            return;
        }

        combi(0, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void combi(int idx, int start) {
        if (idx == m) {
            isVisited = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                Virus virus = list.get(combi[i]);
                isVisited[virus.x][virus.y] = true;
                q.add(virus);
            }
            bfs();
            return;
        }

        for (int i = start; i < list.size(); i++) {
            combi[idx] = i;
            combi(idx + 1, i + 1);
        }
    }

    private static void bfs() {
        int cnt = 0;
        int blank2 = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Virus virus = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = virus.x + dx[i];
                    int ny = virus.y + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] != 1 && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.add(new Virus(nx, ny));
                        if(arr[nx][ny] == 0){
                            blank2++;
                        }
                    }
                }
            }
            cnt++;
            if (blank == blank2) {
                answer = Math.min(answer, cnt);
            }
        }
    }
}

class Virus {
    int x;
    int y;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
