import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[][] arr;
    int min = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        //하나 안쓰면 됨
        arr = new int[n + 1][n + 1];
        for (int[] wire : wires) {
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            arr[wire[0]][wire[1]] = 0;
            arr[wire[1]][wire[0]] = 0;
            bfs(n, wire[0]);
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }
        return min;
    }

    private void bfs(int n, int start) {
        boolean[] isVisited = new boolean[n + 1];
        isVisited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[cur][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    cnt++;
                    q.add(i);
                }
            }
        }
        min = Math.min(min, Math.abs(n - 2 * cnt));
    }
}