import java.util.*;

class Solution {

    char[][] map;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int[] solution(String[] maps) {

        List<Integer> list = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (map[i][j] != 'X') {
                    list.add(bfs(i, j));
                }
            }
        }

        if (list.size() == 0) {
            return new int[]{-1};
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private int bfs(int i, int j) {
        int sum = map[i][j] - '0';
        map[i][j] = 'X';

        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length && map[nx][ny] != 'X') {
                    sum += map[nx][ny] - '0';
                    map[nx][ny] = 'X';
                    q.add(nx);
                    q.add(ny);
                }
            }
        }

        return sum;
    }
}