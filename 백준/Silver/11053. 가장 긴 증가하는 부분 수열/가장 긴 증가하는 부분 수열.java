import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //답, 처음배열1초기화
        int answer = 1;
        int[] dp = new int[n];
        dp[0] = 1;

        //반복최댓값 뒤에서부터 돌면서 원래배열이 앞보다 클때 숫자배열 최댓값보다 클때 최댓값 바꿔 숫자배열에+1해서 담아 답최대
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j] > max) max = dp[j];
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}