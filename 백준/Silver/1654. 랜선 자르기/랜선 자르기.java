import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            int l = sc.nextInt();
            max = Math.max(max, l);
            arr[i] = l;
        }
        //만들 수 있으면 길이 올려, 없으면 내려
        long left = 0;
        long right = max + 1;
        long mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            int cnt = 0;
            for (int l : arr) {
                cnt += l / mid;
            }
            if (cnt >= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left - 1);
    }
}