import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

//    static int c;
//    static int r;
//    static int h;
//    static int[][][] arr;
//    static int[] dx = {0, 0, 1, -1};
//    static int[] dy = {1, -1, 0, 0};
//    static int[] dz = {1, -1};
//

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            s = br.readLine();
            int len = Integer.parseInt(s);
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            ArrayDeque<Integer> q = new ArrayDeque<Integer>();
            for (int k = 0; k < len; k++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            ac(command, q);
        }
    }

    private static void ac(String command, ArrayDeque<Integer> q) {
        boolean right = true;
        for (int j = 0; j < command.length(); j++) {
            if (command.charAt(j) == 'R') {
                if (right) {
                    right = false;
                } else {
                    right = true;
                }
                continue;
            }
            if (q.isEmpty()) {
                System.out.println("error");
                return;
            }
            if (right) {
                q.pollFirst();
            } else {
                q.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (right) {
            if (!q.isEmpty()) {
                sb.append(q.pollFirst());
            }
            while (!q.isEmpty()) {
                sb.append("," + q.pollFirst());
            }
        } else {
            if (!q.isEmpty()) {
                sb.append(q.pollLast());
            }
            while (!q.isEmpty()) {
                sb.append("," + q.pollLast());
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

}