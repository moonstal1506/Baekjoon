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
	static StringBuilder sb = new StringBuilder();

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N;
	static Fish shark;
	static int[][] map;
	static int[][] isVisited;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int fish = Integer.parseInt(st.nextToken());
				if (fish == 9) {
					shark = new Fish(i, j, 2);
					map[i][j] = 0;
					continue;
				}
				map[i][j] = fish;
			}
		}
		bfs(shark);
		System.out.println(answer);
	}

	private static void bfs(Fish shark) {
		// bfs 먹을 수 있는 물고기 최소 위치에 있는애 저장하고 위, 왼쪽 먼저 PQ에서 poll
		// 먹으면 위치를 거기로 세팅
		isVisited = new int[N][N];
		isVisited[shark.x][shark.y] = 1;
		Queue<Fish> q = new LinkedList();
		q.add(shark);

		while (!q.isEmpty()) {
			int quantity = q.size();
			PriorityQueue<Fish> fishes = new PriorityQueue<>();
			for (int i = 0; i < quantity; i++) {
				// PriorityQueue<Fish> fishes = new PriorityQueue<>();
				Fish fish = q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = fish.x + dx[j];
					int ny = fish.y + dy[j];

					// 갈 수 있는지
					if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] > shark.size || isVisited[nx][ny] != 0) {
						continue;
					}

					// 거리구하고 갈 수 있는지도??
					// 먹을 리스트 일단 킵
					// 갈 수 있는 리스트 따로?
					// 먹을 수 있는지
					isVisited[nx][ny] = isVisited[fish.x][fish.y] + 1;
//					System.out.println(isVisited[nx][ny]);
//                    System.out.println(map[nx][ny]+" "+shark.size);
					if ((map[nx][ny] != 0) && (map[nx][ny] < shark.size)) {
						fishes.add(new Fish(nx, ny, map[nx][ny]));
					}
					q.add(new Fish(nx, ny, map[nx][ny]));
				}

//				for (int k = 0; k < N; k++) {
//					System.out.println(Arrays.toString(map[k]));
//				}
//				System.out.println();
//				for (int k = 0; k < N; k++) {
//					System.out.println(Arrays.toString(isVisited[k]));
//				}
//				System.out.println("=======");
			}
			if (!fishes.isEmpty()) {
				Fish food = fishes.poll();
				shark.eat(food);
				map[food.x][food.y] = 0;
//                System.out.println("shark" + shark);
				answer += isVisited[shark.x][shark.y] - 1;
//                System.out.println(answer);
				bfs(shark);
				return;
			}
		}

	}
}

class Fish implements Comparable<Fish> {
	int x;
	int y;
	int size;
	int cnt = 0;

	public Fish(int x, int y, int size) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public void eat(Fish food) {
		this.x = food.x;
		this.y = food.y;

		++cnt;
		if (cnt == size) {
			++size;
			cnt = 0;
		}
	}

	@Override
	public int compareTo(Fish o) {
		if (this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}

	@Override
	public String toString() {
		return "Fish [x=" + x + ", y=" + y + ", size=" + size + ", cnt=" + cnt + "]";
	}
}