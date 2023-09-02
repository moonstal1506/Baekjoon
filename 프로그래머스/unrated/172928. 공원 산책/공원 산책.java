import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    int[] dx = {0, 0, 1, -1}; //E,W,S,N
    int[] dy = {1, -1, 0, 0};
    char[][] map;

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        map = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for (String route : routes) {
            String[] split = route.split(" ");
            int n = Integer.parseInt(split[1]);

            if (split[0].equals("E")) {
                go(park, answer, n, 0);
                continue;
            }
            if (split[0].equals("W")) {
                go(park, answer, n, 1);
                continue;
            }
            if (split[0].equals("S")) {
                go(park, answer, n, 2);
                continue;
            }
            if (split[0].equals("N")) {
                go(park, answer, n, 3);
            }
        }
        return answer;
    }

    private void go(String[] park, int[] answer, int n, int type) {
        System.out.println(Arrays.toString(answer));
        int nx = answer[0];
        int ny = answer[1];
        for (int i = 0; i < n; i++) {
            nx += dx[type];
            ny += dy[type];
            if (nx < 0 || nx > park.length - 1 || ny < 0 || ny > park[0].length() - 1) {
                return;
            }
            if (map[nx][ny] == 'X') {
                return;
            }

        }
        answer[0] += n * dx[type];
        answer[1] += n * dy[type];
    }
}