class Solution {
    public int solution(int[][] board) {
        //보드의 열과 행크기
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        if (row < 2 || col < 2) {
            return 1;
        }

        //현재 1이면 정사각형크기 1부터 돌면서 왼, 위, 왼위 최솟값 +1
        //최댓값 비교
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(Math.min(board[i][j - 1], board[i - 1][j]), board[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        return answer * answer;
    }
}