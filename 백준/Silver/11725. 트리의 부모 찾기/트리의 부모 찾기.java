import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] isVisited;
    static int[] parent;
    static List<Integer>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int parentNode) {
        isVisited[parentNode] = true;
        List<Integer> childNodes = list[parentNode];
        for (int childNode : childNodes) {
            if (isVisited[childNode]) {
                continue;
            }
            parent[childNode] = parentNode;
            dfs(childNode);
        }
    }

}