class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] arr = new boolean[n + 1][n + 1];
        for (int[] result : results) {
            arr[result[0]][result[1]] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (arr[j][i] && arr[i][k]) {
                        arr[j][k] = true;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] || arr[j][i]) {
                    cnt++;
                }
            }
            if (cnt == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}