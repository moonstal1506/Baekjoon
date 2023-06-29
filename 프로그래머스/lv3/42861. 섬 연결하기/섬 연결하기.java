import java.util.Arrays;

class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        for (int[] cost : costs) {
            int a = find(cost[0]);
            int b = find(cost[1]);
            if (a == b) {
                continue;
            }
            answer += cost[2];
            parent[a] = b;
        }
        return answer;
    }

    private int find(int num) {
        if (num == parent[num]) {
            return num;
        }
        return parent[num] = find(parent[num]);
    }
}
