class Solution {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};//오,왼,아래, 위
    boolean[][][] isVisited = new boolean[11][11][4];

    public int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        int d = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char direction = dirs.charAt(i);
            if (direction == 'R') {
                d = 0;
            }
            if (direction == 'L') {
                d = 1;
            }
            if (direction == 'D') {
                d = 2;
            }
            if (direction == 'U') {
                d = 3;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11) {
                continue;
            }

            if (!isVisited[nx][ny][d]) {
                answer++;
                isVisited[nx][ny][d] = true;
                if (d % 2 == 0) {
                    isVisited[x][y][d + 1] = true;
                } else {
                    isVisited[x][y][d - 1] = true;
                }
            }
            x = nx;
            y = ny;
        }

        return answer;
    }
}