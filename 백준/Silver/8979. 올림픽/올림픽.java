import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int n = Integer.parseInt(st.nextToken());
        int country = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][4];
        for (int i = 0; i < n; i++) {
            String medal = br.readLine();
            st = new StringTokenizer(medal, " ");
            int curCountry = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) {
                arr[curCountry][j] = Integer.parseInt(st.nextToken());
            }
        }

        findRank(n, arr, country);
    }

    private static void findRank(int n, int[][] arr, int country) {
        int rank = 1;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int medal = 0; medal < 3; medal++) {
            max = 0;
            for (int j = 1; j <= n; j++) {
                if (map.containsKey(j)) {
                    continue;
                }
                max = Math.max(arr[j][medal], max);
            }

            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (max == arr[country][medal]) {
                    System.out.println(rank);
                    return;
                }

                if (map.containsKey(j)) {
                    continue;
                }

                if (max == arr[j][medal]) {
                    map.put(j, rank);
                    cnt++;
                }
            }
            rank += cnt;
        }
    }
}