import java.util.*;

class Solution {
    static boolean isVisited[][];

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char copy[][] = new char[m][n];
        for (int i = 0; i < m; i++) {
            copy[i] = board[i].toCharArray();
        }

        boolean flag = true;
        while (flag) {
            isVisited = new boolean[m][n];
            flag = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (copy[i][j] == '#') continue;
                    if (check(i, j, copy)) {
                        isVisited[i][j] = true;
                        isVisited[i][j + 1] = true;
                        isVisited[i + 1][j] = true;
                        isVisited[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            answer += erase(m, n, copy);
            isVisited = new boolean[m][n];
        }
        return answer;
    }

    public static boolean check(int x, int y, char[][] board) {
        char ch = board[x][y];
        return ch == board[x][y + 1] && ch == board[x + 1][y] && ch == board[x + 1][y + 1];
    }

    public static int erase(int m, int n, char[][] board) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j])
                    board[i][j] = '.';
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (board[j][i] == '.') {
                    cnt++;
                } else {
                    q.add(board[j][i]);
                }
            }
            int idx = m - 1;
            while (!q.isEmpty()) {
                board[idx--][i] = q.poll();
            }
            for (int j = idx; j >= 0; j--) {
                board[j][i] = '#';
            }
        }

        return cnt;
    }
}
