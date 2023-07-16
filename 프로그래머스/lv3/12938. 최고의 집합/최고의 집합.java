import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }
        int num = s / n;
        int remain = s % n;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }
        for (int i = 0; i < remain; i++) {
            answer[i]++;
        }
        Arrays.sort(answer);
        return answer;
    }
}