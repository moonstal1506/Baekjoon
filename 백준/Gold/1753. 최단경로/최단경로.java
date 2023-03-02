import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//정점의 개수 V와 간선의 개수 E
//시작 정점의 번호 K
//E개의 줄에 걸쳐 u에서 v로 가는 가중치 w인 간선
//출력 - 첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Node>[] list;
	static int V, E, K;
	static int[] distance;
	static boolean[] visited;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		distance = new int[V + 1];

		Arrays.fill(distance, INF);

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}

		dijk(K);

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++){
            if(distance[i] == INF) sb.append("INF\n");
            else sb.append(distance[i] + "\n");
        }
		System.out.println(sb);
	}

	private static void dijk(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[V + 1];
		distance[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int cur = now.v;
			if (visited[cur]) {
				continue;
			}
			visited[cur] = true;

			for (Node node : list[cur]) {
				if (distance[node.v] > distance[cur] + node.w) {
					distance[node.v] = distance[cur] + node.w;
					pq.add(new Node(node.v, distance[node.v]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int v;
	int w;

	public Node(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.w - o.w;
	}

}