import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int n, answer;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n+1][10];

        for (int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    arr[i][j] += arr[i - 1][k];
                    arr[i][j] %= 10007;
                }
            }
        }

        System.out.println(arr[n][0]);
    }

}