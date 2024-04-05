import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] a, b;
    static Integer[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        arr = new Integer[a.length][b.length];
        System.out.println(lcs(a.length - 1, b.length - 1));
    }

    private static int lcs(int x, int y) {
        //공집합
        if (x == -1 || y == -1) {
            return 0;
        }

        //탐색하지 않았을 경우
        if (arr[x][y] == null) {
            arr[x][y] = 0;
            //같으면 대각선 +1
            if (a[x] == b[y]) {
                arr[x][y] = lcs(x - 1, y - 1) + 1;
            } else {
                //다르면 행, 열 부분에서 큰거 가져와
                arr[x][y] = Math.max(lcs(x, y - 1), lcs(x - 1, y));
            }
        }

        //이미 구한거
        return arr[x][y];
    }


}