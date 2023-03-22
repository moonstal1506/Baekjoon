import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        List<Event> list = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            list.add(new Event(deadline, ramen));
            max = Math.max(max, deadline);
        }

        Collections.sort(list);
        int sum = 0;
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).deadline < i) {
                    break;
                }
                q.add(list.get(j).ramen);
            }
            if (!q.isEmpty()) {
                sum += q.poll();
            }
        }
        System.out.println(sum);
    }

    static class Event implements Comparable<Event> {
        int deadline;
        int ramen;

        public Event(int deadline, int ramen) {
            super();
            this.deadline = deadline;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Event o) {
            return o.deadline - deadline;
        }
    }
}