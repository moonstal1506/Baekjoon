import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] friend;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        friend = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1, 0);

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if(friend[i]) answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(int k, int idx) {
        if (idx == 2) return;
        ArrayList<Integer> arr = list.get(k);
        for (int i : arr) {
            friend[i] = true;
            dfs(i, idx + 1);
        }
    }
}
