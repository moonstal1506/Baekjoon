import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> a;
	static ArrayList<Integer> b;
	static ArrayList<Integer>[] list;
	static int min = Integer.MAX_VALUE;
	static boolean[] isVisited;
	static int[] num;
	static int N;

	// 첫째 줄에 구역의 개수 N
	// 둘째 줄에 구역의 인구가 1번 구역부터 N번 구역까지
	// 첫 번째 정수는 그 구역과 인접한 구역의 수이고, 이후 인접한 구역의 번호
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = new int[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int node = Integer.parseInt(st.nextToken());
				list[i].add(node);
			}
		}

		// 부분 집합 구하기
		for (int s = 1; s < (1 << N) - 1; s++) {
			a = new ArrayList<>();
			b = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if ((s & 1 << j) != 0) {
					a.add(j + 1);
				} else {
					b.add(j + 1);
				}
			}

			// 가능하면 인구 차이 최소
			isVisited = new boolean[N + 1];
			if (bfs(a.get(0), a) && bfs(b.get(0), b)) {
				min = Math.min(min, Math.abs(sum(a) - sum(b)));
			}
		}

		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	private static boolean bfs(int start, ArrayList<Integer> unit) {
		isVisited[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int cnt = 1;
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int next : list[node]) {
				if (isVisited[next] || !unit.contains(next)) {
					continue;
				}
				q.add(next);
				isVisited[next] = true;
				cnt++;
			}
		}
		return cnt == unit.size();
	}

	private static int sum(ArrayList<Integer> unit) {
		int sum = 0;
		for (int i = 0; i < unit.size(); i++) {
			sum += num[unit.get(i)];
		}
		return sum;
	}
}