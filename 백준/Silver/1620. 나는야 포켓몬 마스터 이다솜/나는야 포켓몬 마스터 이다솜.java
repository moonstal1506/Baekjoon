import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            map.put(i, s);
            map2.put(s, i);
        }

        for (int i = 1; i <= m; i++) {
            String s = br.readLine();
            if (0 <= s.charAt(0) - '0' && s.charAt(0) - '0' <= 9) {
                System.out.println(map.get(Integer.parseInt(s)));
            } else {
                System.out.println(map2.get(s));
            }
        }
    }
}