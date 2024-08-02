import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (b != a) {
            String str = String.valueOf(b);
            if (b % 2 == 0) {
                b /= 2;
            } else if (str.charAt(str.length() - 1) == '1') {
                b = Integer.parseInt(str.substring(0, str.length() - 1));
            } else {
                cnt = -1;
                break;
            }

            if (b < a) {
                cnt = -1;
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }

}