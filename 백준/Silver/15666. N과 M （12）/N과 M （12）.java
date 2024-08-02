import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int m, n;
    static int[] arr, arr2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int start, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr2[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for (int i = start; i < n; i++) {
            if (before != arr[i]) {
                arr2[cnt] = arr[i];
                before = arr[i];
                dfs(i, cnt + 1);
            }
        }
    }

}