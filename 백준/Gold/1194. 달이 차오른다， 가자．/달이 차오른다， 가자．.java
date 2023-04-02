import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static char[][] arr;
	static int n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int x = 0, y = 0;
		arr = new char[n][m];

		// 입력완
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '0') {
					x = i;
					y = j;
				}
			}
		}

		System.out.println(bfs(new Point(x, y, 0, 0)));
	}

	private static int bfs(Point point) {
		boolean[][][] isVisited = new boolean[n][m][64];
		Queue<Point> q = new LinkedList<>();
		q.add(point);

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int key = cur.key;

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}

				if (arr[nx][ny] == '1') {
					return cur.cnt + 1;
				}

				if (arr[nx][ny] == '#') {
					continue;
				}

				if (isVisited[nx][ny][cur.key]) {
					continue;
				}

				if ('a' <= arr[nx][ny] && arr[nx][ny] <= 'f') {
					key |= (1 << (arr[nx][ny] - 'a'));
				}

				if ('A' <= arr[nx][ny] && arr[nx][ny] <= 'F') {
					if ((cur.key & (1 << (arr[nx][ny] - 'A'))) == 0) {
                        continue;
                    }
				}
//				System.out.println(new Point(nx, ny, cur.cnt + 1, cur.key));
				isVisited[nx][ny][key] = true;
				q.add(new Point(nx, ny, cur.cnt + 1, key));
			}
		}
		return -1;
	}
}

class Point {
	int x;
	int y;
	int cnt;
	int key;

	public Point(int x, int y, int cnt, int key) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.key = key;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + ", key=" + key + "]";
	}
	
	
}