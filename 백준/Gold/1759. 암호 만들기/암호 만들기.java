import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static String[] arr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //암호길이, 알파벳 수 ,알파벳 담기, 정렬, dfs(암호,인덱스)
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new String[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        dfs("", 0);
    }

    //암호길이완료 자모 체크, 사용한다 사용하지 않는다.
    private static void dfs(String ans, int idx) {
        if (ans.length() == n) {
            if (check(ans)) {
                System.out.println(ans);
            }
            return;
        }
        if (idx >= arr.length) return;
        dfs(ans + arr[idx], idx + 1);
        dfs(ans, idx + 1);
    }

    //암호 돌려 if문 자모체크
    private static boolean check(String ans) {
        int mo = 0;
        int ja = 0;
        for (char ch : ans.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mo++;
            } else {
                ja++;
            }
        }
        return mo >= 1 && ja >= 2;
    }
}