import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        int ex = maps.length - 1;
        int ey = maps[0].length - 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size() / 2;
            cnt++;
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                int y = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx == ex && ny == ey) {
                        return cnt + 1;
                    }
                    if (nx < 0 || nx >= ex + 1 || ny < 0 || ny >= ey + 1 || maps[nx][ny] == 0) {
                        continue;
                    }
                    maps[nx][ny] = 0;
                    q.add(nx);
                    q.add(ny);
                }
            }
        }
        return -1;
    }
}