import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Edge> list = new ArrayList<>();
	static int[] parents;
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		parents = new int[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if (i == j) {
					continue;
				}
				list.add(new Edge(i, j, cost));
			}
		}
		Collections.sort(list);
		
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		long answer = 0;
		for (Edge edge : list) {
			if (find(edge.start) != find(edge.end)) {
				answer += edge.cost;
				union(edge.start, edge.end);
			}
		}

		System.out.println(answer);
	}

	private static void union(int start, int end) {
		parents[find(start)] = find(end);

	}

	private static int find(int n) {
		if (parents[n] == n) {
			return n;
		}
		return parents[n] = find(parents[n]);
	}

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;

		public Edge(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return cost - o.cost;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}
		
		
	}
}