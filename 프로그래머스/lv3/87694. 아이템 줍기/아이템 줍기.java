import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] map;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int answer = solution.solution(rectangle, 1, 3, 7, 8);
        System.out.println(answer);
    }

    private static boolean isOut(int nx, int ny) {
        return nx < 0 || nx >= 101 || ny < 0 || ny >= 101;
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        for (int[] location : rectangle) {
            int sx = location[0] * 2;
            int sy = location[1] * 2;
            int ex = location[2] * 2;
            int ey = location[3] * 2;
            for (int i = sx; i <= ex; i++) {
                for (int j = sy; j <= ey; j++) {
                    if(map[i][j]==2) continue;
                    map[i][j] = 2;
                    if (i == sx || i == ex || j == sy || j == ey) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        int answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer / 2;
    }

    private int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Integer> q = new LinkedList<>();
        q.add(characterX);
        q.add(characterY);
        map[characterX][characterY] = 2;
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            //사이즈만큼 돌기
            int size = q.size() / 2;
            for (int i = 0; i < size; i++) {
                int cx = q.poll();
                int cy = q.poll();
                //갈 수 있으면 담아
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    //도착하면 리턴
                    if (nx == itemX && ny == itemY) {
                        return cnt;
                    }
                    if (isOut(nx, ny)) continue;
                    if (map[nx][ny] == 1) {
                        q.add(nx);
                        q.add(ny);
                        map[nx][ny] = 2;
                    }
                }
            }
        }
        return 0;
    }
}