import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] check = new boolean[N+1];
		PriorityQueue<Edge> q = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			q.add(new Edge(i, sc.nextInt()));
		}
		
		List<Edge>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int k= sc.nextInt();
				list[i].add(new Edge(j, k));
				list[j].add(new Edge(i, k));
			}
		}
		
		int answer=0;
		while(!q.isEmpty()) {
			Edge now =q.poll();
			if(!check[now.idx]) {
				check[now.idx]=true;
				answer+=now.cost;
				for(Edge edge : list[now.idx]) {
					if(!check[edge.idx]) {
						q.add(new Edge(edge.idx, edge.cost));
					}
				}
			}
		}

		System.out.println(answer);
	}
	
	static class Edge implements Comparable<Edge>{

		int idx;
		int cost;
		
		public Edge(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}

		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", cost=" + cost + "]";
		}
		
		
		
	}
}