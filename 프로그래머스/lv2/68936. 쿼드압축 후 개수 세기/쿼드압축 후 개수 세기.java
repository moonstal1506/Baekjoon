class Solution {
    int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];
        dfs(arr, 0, 0, arr.length);
        return answer;
    }

    private void dfs(int[][] arr, int x, int y, int size) {
        if (conquer(arr, x, y, size)) {
            if (arr[x][y] == 1) {
                answer[1]++;
            } else {
                answer[0]++;
            }
            return;
        }

        dfs(arr, x, y, size / 2);
        dfs(arr, x, y + size / 2, size / 2);
        dfs(arr, x + size / 2, y, size / 2);
        dfs(arr, x + size / 2, y + size / 2, size / 2);
    }

    private boolean conquer(int[][] arr, int x, int y, int size) {
        for (int i = x ; i < x + size; i++) {
            for (int j = y ; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}