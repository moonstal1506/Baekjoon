import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[][] dp;
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        dp= new int[n+1][k+1];
        System.out.println(bc(n,k));
    }

    private static int bc(int n, int k) {
        if(dp[n][k]>0){
            return dp[n][k];
        }

        if(k==0||n==k){
            return 1;
        }

        return dp[n][k] = bc(n - 1, k - 1) + bc(n - 1, k);
    }
}