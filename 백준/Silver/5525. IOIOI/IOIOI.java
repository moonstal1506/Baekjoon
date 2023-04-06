import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();

        StringBuilder sb = new StringBuilder();
        sb.append("I");
        for (int i = 0; i < n; i++) {
            sb.append("OI");
        }
        int answer = 0;
        String pattern = sb.toString();
        for (int i = 0; i <= m - pattern.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < pattern.length(); j++) {
                if (s.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }

                cnt++;
            }
            if (cnt == pattern.length()) {
//                System.out.println(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
}