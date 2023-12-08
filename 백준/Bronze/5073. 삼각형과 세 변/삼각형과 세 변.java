import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            int max = 0;
            int idx = 0;
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (max < arr[i]) {
                    max = arr[i];
                    idx = i;
                }
            }
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                if (i == idx) {
                    continue;
                }
                sum += arr[i];
            }
            if (sum <= max) {
                System.out.println("Invalid");
                continue;
            }

            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            int cnt = 0;
            if (a == b) {
                cnt++;
            }
            if (a == c) {
                cnt++;
            }
            if (b == c) {
                cnt++;
            }
            if (cnt == 3) {
                System.out.println("Equilateral");
                continue;
            }
            if (cnt == 1) {
                System.out.println("Isosceles");
                continue;
            }
            System.out.println("Scalene");
        }
    }
}