import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int idx = 0;
        int end = 0;
        int time = 0;
        int cnt = 0;
        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= end) {
                q.add(jobs[idx++]);
            }
            if (q.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] poll = q.poll();
                time += end - poll[0] + poll[1];
                end += poll[1];
                cnt++;
            }
        }

        return time / jobs.length;
    }
}