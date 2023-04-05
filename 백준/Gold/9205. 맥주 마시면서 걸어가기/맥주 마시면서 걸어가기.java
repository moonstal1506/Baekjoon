import java.io.IOException;
import java.util.*;

public class Main {
    static List<Position> list ;
    static boolean[] isVisited;
    static int N;

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            list = new ArrayList<>();
            N = sc.nextInt();
            isVisited = new boolean[N + 1];
            Position start = new Position(sc.nextInt(), sc.nextInt());
            for (int i = 0; i < N; i++) {
                list.add(new Position(sc.nextInt(), sc.nextInt()));
            }
            Position end = new Position(sc.nextInt(), sc.nextInt());
            list.add(end);
            System.out.println(go(start, end));
        }
    }

    private static String go(Position start, Position end) {
        Queue<Position> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Position cur = q.poll();
            if (cur.x == end.x && cur.y == end.y) {
                return "happy";
            }
            for (int i = 0; i < N +1; i++) {
                if(isVisited[i]) {
                    continue;
                }
                Position position = list.get(i);
                int distance = Math.abs(cur.x - position.x) + Math.abs(cur.y - position.y);
                if (distance <= 1000) {
                    isVisited[i]=true;
                    q.add(position);
                }
            }
        }
        return "sad";
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

}