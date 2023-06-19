import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] arr = new int[n + 1];
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            int[] node = edge[i];
            list[node[0]].add(node[1]);
            list[node[1]].add(node[0]);
        }
        arr[1] = 0;
        Queue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));
        int max = 0;
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            for (int next : list[cur.node]) {
                if (arr[next] == Integer.MAX_VALUE) {
                    max = arr[next] = cur.cost + 1;
                    q.add(new Edge(next, max));
                }
            }
        }
        int answer = 0;
        for (int distance : arr) {
            if (distance == max) {
                answer++;
            }
        }
        return answer;
    }
}

class Edge implements Comparable<Edge> {
    int node;
    int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}