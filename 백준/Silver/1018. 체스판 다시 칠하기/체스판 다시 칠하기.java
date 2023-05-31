import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int min = Integer.MAX_VALUE;
    static boolean[][] arr;
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String next = sc.next();
            for (int j = 0; j < m; j++) {
                char c = next.charAt(j);
                arr[i][j]=c=='W';
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                count(i, j);
            }
        }

        System.out.println(min);
    }

    private static void count(int x, int y) {
        boolean start = arr[x][y];
        int cnt = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if(start!=arr[i][j]){
                    cnt++;
                }
                start=!start;
            }
            start=!start;
        }
        min = Math.min(min, Math.min(cnt, 64 - cnt));
    }
}