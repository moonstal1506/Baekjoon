import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int m = sc.nextInt();
            System.out.println(dfs(0,m));
        }

    }

    private static int dfs(int sum, int m) {
        if(sum>m) return 0;
        if(sum==m) return 1;

        int answer=0;
        for (int i = 1; i <= 3; i++) {
            answer+= dfs(sum+i,m);
        }
        return answer;
    }
}