import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static Queue<Point> Q = new LinkedList<>();
	static int[][] map;
	static int answer;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					Q.add(new Point(i, j));
				}
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}

		if (cnt == 0) {
			System.out.println(0);
		} else {
			bfs();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						answer = -1;
					}
				}
			}

			System.out.println(answer);
		}
	}

	private static void bfs() {
		while (!Q.isEmpty()) {
			int size = Q.size();
			answer++;
			for (int i = 0; i < size; i++) {
				Point p = Q.poll();

				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (0 > nx || 0 > ny || N <= nx || M <= ny) {
						continue;
					}

					if (map[nx][ny] != 0) {
						continue;
					}

					map[nx][ny] = 1;
					Q.add(new Point(nx, ny));
				}
			}
		}
		answer-=1;
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