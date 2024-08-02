import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                max[0] = min[0] = a;
                max[1] = min[1] = b;
                max[2] = min[2] = c;
            } else {
                int tmp0 = max[0];
                int tmp2 = max[2];
                max[0] = Math.max(max[0], max[1]) + a;
                max[2] = Math.max(max[2], max[1]) + c;
                max[1] = Math.max(Math.max(tmp0, max[1]), tmp2) + b;

                tmp0 = min[0];
                tmp2 = min[2];
                min[0] = Math.min(min[0], min[1]) + a;
                min[2] = Math.min(min[2], min[1]) + c;
                min[1] = Math.min(Math.min(tmp0, min[1]), tmp2) + b;
            }
        }
        
        Arrays.sort(max);
        Arrays.sort(min);
        System.out.println(max[2] + " " + min[0]);
    }

}