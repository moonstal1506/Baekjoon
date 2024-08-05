import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][8];
        for (int i = 1; i <= 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            go(num, dir);
        }
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i + 1][0] == '1') {
                score += Math.pow(2, i);
            }
        }
        System.out.println(score);
    }

    private static void go(int num, int dir) {
        left(num - 1, -dir);
        right(num + 1, -dir);
        rotation(num, dir);
    }

    static void left(int num, int dir) {
        if (num < 1) return;
        if (arr[num][2] == arr[num + 1][6]) return;
        left(num - 1, -dir);
        rotation(num, dir);
    }

    static void right(int num, int dir) {
        if (num > 4) return;
        if (arr[num][6] == arr[num - 1][2]) return;
        right(num + 1, -dir);
        rotation(num, dir);
    }

    static void rotation(int num, int dir) {
        if (dir == 1) {
            char tmp = arr[num][7];
            for (int i = 7; i > 0; i--) {
                arr[num][i] = arr[num][i - 1];
            }
            arr[num][0] = tmp;
        } else {
            char tmp = arr[num][0];
            for (int i = 0; i < 7; i++) {
                arr[num][i] = arr[num][i + 1];
            }
            arr[num][7] = tmp;
        }
    }

}