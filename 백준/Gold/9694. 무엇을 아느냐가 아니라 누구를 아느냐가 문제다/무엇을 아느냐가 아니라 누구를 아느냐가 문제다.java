import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Edge>[] arr = new ArrayList[m];
            int[] history = new int[m];
            Edge[] distance = new Edge[m];

            for (int i = 0; i < m; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();

                arr[x].add(new Edge(y, z));
                arr[y].add(new Edge(x, z));
            }

            distance[0] = new Edge(0, 0);
            for (int i = 1; i < m; i++) {
                distance[i] = new Edge(0, Integer.MAX_VALUE);
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(distance[0]);

            while (!pq.isEmpty()) {
                Edge now = pq.poll();
                for (Edge next : arr[now.v]) {
                    if (distance[next.v].w > distance[now.v].w + next.w) {
                        distance[next.v] = new Edge(next.v, distance[now.v].w + next.w);
                        pq.add(distance[next.v]);
                        history[next.v] = now.v;
                    }
                }
            }

            if (distance[m - 1].w == Integer.MAX_VALUE) {
                System.out.println("Case #" + tc + ": " + -1);
            } else {
                int now = m - 1;
                Stack<Integer> friend = new Stack<>();
                friend.add(now);
                while (now != 0) {
                    friend.add(history[now]);
                    now = history[now];
                }
                System.out.print("Case #" + tc + ": ");
                while (!friend.isEmpty()) {
                    System.out.print(friend.pop() + " ");
                }
                System.out.println();
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
    }
}