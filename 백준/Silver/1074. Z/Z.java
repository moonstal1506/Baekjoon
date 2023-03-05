import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cnt = 0;
    static int N;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        cut(0, 0, size);
    }

    private static void cut(int r, int c, int size) {
        //도착하면 출력
        if (r == R && c == C) {
            System.out.println(cnt);
            return;
        }

        //포함되어있으면 또 잘라
        if (r <= R && R < (r + size) && c <= C && C < (c + size)) {
            int half = size / 2;
            //순서 중요
            cut(r, c, half);
            cut(r, c + half, half);
            cut(r + half, c, half);
            cut(r + half, c + half, half);
        } else {
            //포함 아니면 사이즈*사이즈 증가
            cnt += size * size;
        }
    }

}