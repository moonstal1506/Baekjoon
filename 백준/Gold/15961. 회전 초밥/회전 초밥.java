import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();

        int[] belt = new int[n];
        int[] kind = new int[d + 1];

        for (int i = 0; i < n; i++) {
            belt[i] = sc.nextInt();
        }
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (kind[belt[i]] == 0) {
                cnt++;
            }
            kind[belt[i]]++;
        }
        max = cnt;

        for (int i = 1; i < n; i++) {
            if (max <= cnt) {
                //쿠폰체크
                if (kind[c] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }
            //슬라이딩
            kind[belt[i - 1]]--;
            if(kind[belt[i-1]]==0) cnt--;

            if(kind[belt[(i +k-1)%n]]==0) cnt++;
            kind[belt[(i +k-1)%n]]++;
        }
        System.out.println(max);
    }
}