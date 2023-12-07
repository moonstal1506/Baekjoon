import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        int n = arr[0];
        int k = arr[2] + 1;
        if (n % k == 0) {
            n = n / k;
        } else {
            n = n / k + 1;
        }

        int m = arr[1];
        k = arr[3] + 1;
        if (m % k == 0) {
            m = m / k;
        } else {
            m = m / k + 1;
        }

        System.out.println(n * m);
    }
}