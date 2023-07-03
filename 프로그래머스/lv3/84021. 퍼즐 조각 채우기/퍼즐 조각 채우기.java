import java.util.*;

//import java.util.*;
//
//class Solution {
//
//    public static final int BLANK = 0;
//    public static final int BLOCK = 1;
//    int[] dx = {0, 0, -1, 1};
//    int[] dy = {-1, 1, 0, 0};
//    List<List<Point>> blanks = new ArrayList<>();
//    List<List<Point>> blocks = new ArrayList<>();
//    boolean[][] isVisited;
//    int boardSize;
//
//    public int solution(int[][] game_board, int[][] table) {
//        boardSize = game_board.length;
//        int answer = 0;
//        //game_board 빈공간, table 블록 담기
//        addPosition(game_board, blanks, BLANK);
//        addPosition(table, blocks, BLOCK);
//
//        //블록을 빈공간에 넣어보자
//        boolean[] isUsed = new boolean[blanks.size()];
//        for (int i = 0; i < boardSize; i++) {
//            List<Point> block = blocks.get(i);
//            for (int j = 0; j < blanks.size(); j++) {
//                List<Point> blank = blanks.get(j);
//                //블록개수 같고 방문한적 없을때 돌려보기
//                if (blank.size() != block.size() || isUsed[j]) {
//                    continue;
//                }
//                if (isPossible(block, blank)) {
//                    //가능하면 방문체크하고 답에 블록개수 더하기
//                    answer += block.size();
//                    isUsed[j] = true;
//                    break;
//                }
//            }
//        }
//        return answer;
//    }
//
//    private void addPosition(int[][] board, List<List<Point>> positions, int type) {
//        isVisited = new boolean[boardSize][boardSize];
//        for (int i = 0; i < boardSize; i++) {
//            for (int j = 0; j < boardSize; j++) {
//                if (!isVisited[i][j] && board[i][j] == type) {
//                    positions.add(getPosition(board, type, i, j));
//                }
//            }
//        }
//    }
//
//    private List<Point> getPosition(int[][] board, int type, int x, int y) {
//        List<Point> points = new ArrayList<>();
//        Queue<Point> q = new LinkedList();
//        q.add(new Point(0, 0));
//        isVisited[x][y] = true;
//
//        while (!q.isEmpty()) {
//            Point point = q.poll();
//            for (int i = 0; i < 4; i++) {
//                int nx = point.x + dx[i];
//                int ny = point.y + dy[i];
//
//                if (nx < 0 || nx >= boardSize || ny < 0 || ny >= boardSize || isVisited[nx][ny]) {
//                    continue;
//                }
//
//                if (board[nx][ny] == type) {
//                    isVisited[nx][ny] = true;
//                    q.add(new Point(nx, ny));
//                    points.add(new Point(nx - x, ny - y));
//                }
//            }
//        }
//        Collections.sort(points);
//        return points;
//    }
//
//
//    private boolean isPossible(List<Point> block, List<Point> blank) {
//        for (int i = 0; i < 4; i++) {
//            int x = block.get(0).x;
//            int y = block.get(0).y;
//
//            for (int j = 0; j < block.size(); j++) {
//                block.get(j).x -= x;
//                block.get(j).y -= y;
//            }
//            boolean isPossible = true;
//            for (int j = 0; j < blank.size(); j++) {
//                Point blankPoint = blank.get(j);
//                Point blockPoint = block.get(j);
//
//                if (blankPoint.x != blockPoint.x || blankPoint.y != blockPoint.y) {
//                    isPossible = false;
//                    break;
//                }
//            }
//
//            if (isPossible) {
//                return true;
//            }
//
//            for (int j = 0; j < block.size(); j++) {
//                int tmp = block.get(j).x;
//                block.get(j).x = block.get(j).y;
//                block.get(j).y = -tmp;
//            }
//            Collections.sort(block);
//
//        }
//        return false;
//    }
//}
//
class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (o.x == x) {
            return y - o.y;
        }
        return x - o.x;
    }

}

public class Solution {

    static int[] dx = {-1, 0, 1, 0}; // 상하
    static int[] dy = {0, -1, 0, 1}; // 좌우

    static int boardSize;
    static ArrayList<ArrayList<Point>> empty = new ArrayList<>(); // 게임 보드의 빈 공간 저장
    static ArrayList<ArrayList<Point>> block = new ArrayList<>(); // 테이블의 블록 저장
    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] g1 = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] t1 = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};

        System.out.println(solution(g1, t1));
    }

    public static int solution(int[][] game_board, int[][] table) {
        boardSize = game_board.length;

        visited = new boolean[boardSize][boardSize];

        // 게임 보드의 빈 공간 체크
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    empty.add(check(game_board, i, j, 0));
                }
            }
        }

        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(visited[i], false);
        }

        // 테이블의 블록 체크
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (table[i][j] == 1 && !visited[i][j])
                    block.add(check(table, i, j, 1));
            }
        }
        
        boolean[] visitedBoard = new boolean[empty.size()];
        int answer = 0;

        // 게임 보드의 빈 공간과 테이블의 블록만큼 반복하면서 빈 공간에 블록을 채움
        for (int i = 0; i < block.size(); i++) {
            ArrayList<Point> blockCheck = block.get(i);

            for (int j = 0; j < empty.size(); j++) {
                ArrayList<Point> emptyCheck = empty.get(j);

                // 빈 공간과 블록의 개수가 같고 방문한 적이 없는 곳일 경우
                if (emptyCheck.size() == blockCheck.size() && !visitedBoard[j]) {
                    // 빈 공간에 블록이 들어가는지 확인
                    if (isRotate(emptyCheck, blockCheck)) {
                        // 빈 공간에 블록이 들어간다면 answer에 블록 개수를 더함
                        answer += blockCheck.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    // 게임 보드의 빈 공간과 테이블의 블록을 찾아내는 메소드
    // 탐색할 배열, 탐색할 인덱스, 게임보드와 테이블 구분하는 변수
    public static ArrayList<Point> check(int[][] board, int x, int y, int type) {
        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> result = new ArrayList<>();

        q.add(new Point(x, y));
        visited[x][y] = true;

        // 빈 공간이나 블록의 첫 번째 좌표를 (0, 0)으로 함
        result.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < boardSize && ny >= 0 && ny < boardSize) {
                    if (!visited[nx][ny] && board[nx][ny] == type) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;

                        // 기준이 (0, 0)이기 때문에 (nx - x, ny - y)를 리스트에 넣음
                        result.add(new Point(nx - x, ny - y));
                    }
                }

            }
        }

        Collections.sort(result);

        return result;
    }

    // 블록을 회전시키면서 게임 보드에 들어가는지 확인하는 메소드
    public static boolean isRotate(ArrayList<Point> empty, ArrayList<Point> block) {
        // 90도씩 회전 시키기
        for (int i = 0; i < 4; i++) {
            int zeroX = block.get(0).x;
            int zeroY = block.get(0).y;

            // 회전시키면서 좌표가 달라지기 때문에 다시 (0, 0)을 기준으로 블록 좌표를 변경
            for (int j = 0; j < block.size(); j++) {
                block.get(j).x -= zeroX;
                block.get(j).y -= zeroY;
            }

            boolean isCollect = true;

            for (int j = 0; j < empty.size(); j++) {
                Point emptyPoint = empty.get(j);
                Point blockPoint = block.get(j);

                // 블록 좌표가 빈 공간의 좌표와 하나라도 다르면 중단
                if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y) {
                    isCollect = false;
                    break;
                }
            }

            if (isCollect) {
                return true;
            } else {
                // 90도 회전 : (x, y) -> (y, -x)
                for (int j = 0; j < block.size(); j++) {
                    int temp = block.get(j).x;

                    block.get(j).x = block.get(j).y;
                    block.get(j).y = -temp;
                }

                Collections.sort(block);
            }

        }

        return false;
    }

}