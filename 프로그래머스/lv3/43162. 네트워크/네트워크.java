class Solution {
    boolean[] isVisited;
    int[][] computers;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                answer++;
                isVisited[i] = true;
                dfs(n, i);
            }
        }
        return answer;
    }

    private void dfs(int n, int i) {
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1 && !isVisited[j]) {
                isVisited[i] = true;
                dfs(n, j);
            }
        }
    }
}
