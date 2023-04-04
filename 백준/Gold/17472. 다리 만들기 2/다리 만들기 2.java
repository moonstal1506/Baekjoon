import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//어떤 섬인지 알아야해 번호 부여
//한방향으로 가로, 세로만
//1->2  1->3...가는 최단 거리 구해
//최단거리로 이어붙이기
//근데 거리가 2이상 
//연결했으면 체크
//dfs로 인접한 애들 돌려서 섬 개수 다 들리면 최소값 갱신
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 1, 0, -1}; // 오른 밑
    static int[] dy = {1, 0, -1, 0};

    static int[][] map;
    static boolean[][] isVisited;
    static boolean[] isUsed;
    static int n, m, num;
    static List<Edge>[] list;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m];

        //입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬에 번호 부여
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    check(i, j, ++num);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        list = new ArrayList[num + 1];
        isUsed = new boolean[num + 1];
        for (int i = 1; i <= num; i++) {
            list[i] = new ArrayList<>();
        }

        //거리구함
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    getDistance(i, j);
                }
            }
        }

//        for (int i = 1; i <= num; i++) {
//            System.out.println(list[i]);
//        }

        //최소스패닝트리
        int distance = 0;
        int cnt = 0;
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (isUsed[edge.v]) {
                continue;
            }
            isUsed[edge.v] = true;
            cnt++;
            distance += edge.w;
            if (cnt == num) {
                answer = distance;
//                System.out.println("distance = " + distance);
                break;
            }
            for (Edge next : list[edge.v]) {
                if (isUsed[next.v]) {
                    continue;
                }
                pq.add(new Edge(next.v, next.w));
            }
        }


        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }

    }

    private static void check(int x, int y, int num) {
        isVisited[x][y] = true;
        map[x][y] = num;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || isVisited[nx][ny]) {
                continue;
            }
            if (map[nx][ny] == 1) {
                map[nx][ny] = num;

                check(nx, ny, num);
            }
        }
    }

    private static void getDistance(int x, int y) {
        // 오른쪽이랑 밑만 보면됨
        // 자기자신 아니면 가자
        // 거리가 2이상
        go(x, y, 0);
        go(x, y, 1);
    }

    private static void go(int x, int y, int d) {
        int cur = map[x][y];
        int cnt = 0;
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == map[x][y]) {
                break;
            }
            if (map[nx][ny] == 0) {
                cnt++;
                continue;
            }
            if (map[nx][ny] != 0) {
                if (cnt < 2) {
                    break;
                }
                int next = map[nx][ny];
//                System.out.println(cur+" "+next);
                list[cur].add(new Edge(next, cnt));
                list[next].add(new Edge(cur, cnt));
                break;
            }
        }

    }

    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "e=" + v +
                    ", w=" + w +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return v == edge.v && w == edge.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, w);
        }
    }
}