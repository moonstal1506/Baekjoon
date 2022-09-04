import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            arr = new int[n+1];
            visited = new boolean[n+1];
            System.out.println(count(n));
        }
    }

    private static int count(int n) {
        int answer =0;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                answer++;
                visited[i]=true;
                dfs(arr[i]);
            }
        }
        return answer;
    }

    private static void dfs(int i) {
        if(visited[i]){
            return;
        }else {
            visited[i] = true;
            dfs(arr[i]);
        }
    }
}