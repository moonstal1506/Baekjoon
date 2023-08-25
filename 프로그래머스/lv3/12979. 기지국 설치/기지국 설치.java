class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int apt = 1;

        while (apt <= n) {
            //기지국 범위 안
            if (idx < stations.length && apt >= stations[idx] - w) {
                apt = stations[idx] + w + 1;
                idx++;
            } else {
                // 밖, 기지국 설치
                answer++;
                apt += 2 * w + 1;
            }
        }

        return answer;
    }
}