import java.io.IOException;
import java.util.Scanner;

public class Solution {
    static int n;
    static int[][] arr;
    static boolean[] isSelected;
    static int answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int tc = 1; tc <= size; tc++) {
            n = sc.nextInt();
            arr = new int[n][n];
            isSelected = new boolean[n];
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            getSynergy(0, 0);
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void getSynergy(int cnt, int start) {
        if (cnt == n / 2) {
            int a = 0, b = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //두 음식 간의 맛의 차이가 최소가 되도록 A음식과 B음식을 만들었을 때 그 차이 값
                    if (isSelected[i] && isSelected[j]) {
                        a += arr[i][j];
                    }
                    if (!isSelected[i] && !isSelected[j]) {
                        b += arr[i][j];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(a - b));
            return;
        }

        for (int i = start; i < n; i++) {
            isSelected[i] = true;
            getSynergy(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }
}