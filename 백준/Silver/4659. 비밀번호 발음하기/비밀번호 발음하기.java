import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }
            if (isSafe(s)) {
                sb.append("<").append(s).append("> is acceptable.").append("\n");
            } else {
                sb.append("<").append(s).append("> is not acceptable.").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean isSafe(String s) {
        int cnt = 0;
        int mo = 0;
        int ja = 0;
        char c = ' ';
        for (int i = 0; i < s.length(); i++) {
            String n = String.valueOf(c) + s.charAt(i);
            if (c == s.charAt(i) && !"ee".equals(n) && !"oo".equals(n)) {
                return false;
            }
            c = s.charAt(i);
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                cnt++;
                mo++;
                ja = 0;
                if (mo >= 3) {
                    return false;
                }
            } else {
                ja++;
                mo = 0;
                if (ja >= 3) {
                    return false;
                }
            }
        }
        if (cnt == 0) {
            return false;
        }
        return true;
    }

}