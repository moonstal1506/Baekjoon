class Solution {
    int max = 0;
    boolean[] isVisited;
    int[][] dungeons;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        isVisited = new boolean[dungeons.length];
        permu(k, 0, dungeons.length);
        return max;
    }

    private void permu(int k, int cnt, int size) {
        for (int i = 0; i < size; i++) {
            if (isVisited[i] || k < dungeons[i][0]) {
                continue;
            }
            isVisited[i] = true;
            permu(k - dungeons[i][1], cnt + 1, size);
            isVisited[i] = false;
        }
        max = Math.max(cnt, max);
    }
}