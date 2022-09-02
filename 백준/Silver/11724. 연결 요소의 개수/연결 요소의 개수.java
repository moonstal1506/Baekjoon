import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //정점담아줄곳, 방문여부
    static List<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //정점개수만큼 리스트,방문초기화(1부터임)
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        //간선개수만큼 담아주기, 무방향이므로 둘다 넣어줌
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }

        //1번정점부터 돌면서 방문확인 방문안했으면 +1하고 dfs 호출해서 연결된거 다 방문체크해
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
    }

    //dsf 방문했으면 리턴, 안했으면 방문체크하고 얘 정점에 담긴 애들 dfs돌기
    private static void dfs(int i) {
        if (visited[i]) {
            return;
        } else {
            visited[i] = true;
            for (int num : arr[i]) {
                dfs(num);
            }
        }
    }
}