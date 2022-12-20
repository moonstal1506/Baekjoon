import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            if (q.size() > k - 1) {
                if (q.peek() < score[i]) {
                    q.poll();
                    q.add(score[i]);
                }
            } else {
                q.add(score[i]);
            }
            answer[i] = q.peek();
        }
        return answer;
    }
}