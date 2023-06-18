class Solution {
    int N;
    int number;
    int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        this.N = N;
        this.number = number;
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int cnt, int num) {
        if (cnt > 8) {
            return;
        }
        if (num == number) {
            answer = Math.min(answer, cnt);
            return;
        }
        int n = 0;
        for (int i = 1; i <= 8; i++) {
            n = n * 10 + N;
            dfs(cnt + i, num + n);
            dfs(cnt + i, num - n);
            dfs(cnt + i, num / n);
            dfs(cnt + i, num * n);
        }
    }
}