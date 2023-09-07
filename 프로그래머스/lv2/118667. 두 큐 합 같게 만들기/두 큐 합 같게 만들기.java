import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.add(queue1[i]);

            sum2 += queue2[i];
            q2.add(queue2[i]);
        }
        long half = (sum1 + sum2) / 2;
        while (sum1 != sum2) {
            if (answer > queue1.length * 4) {
                return -1;
            }
            answer++;
            if (sum1 > half) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
                continue;
            }
            if (sum2 > half) {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            }
        }
        return answer;
    }
}