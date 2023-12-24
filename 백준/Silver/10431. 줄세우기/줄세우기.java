import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;
            
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < j; k++) {
                    if (arr[j] < arr[k]) {
                        cnt++;
                    }
                }
            }
            System.out.println(num + " " + cnt);
        }
    }
}