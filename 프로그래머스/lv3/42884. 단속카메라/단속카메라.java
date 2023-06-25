import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int cctv = Integer.MIN_VALUE;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        for (int[] route : routes) {
            if (cctv < route[0]) {
                cctv = route[1];
                answer++;
            }
        }
        return answer;
    }
}