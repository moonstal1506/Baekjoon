import java.util.Scanner;

public class Main {
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        dfs(x,0);
        System.out.println(answer);
    }

    private static void dfs(int x, int cnt) {
        if(cnt>answer) return;
        if(x==1){
            answer = Math.min(answer, cnt);
            return;
        }
        if(x%3==0) dfs(x/3,cnt+1);
        if(x%2==0) dfs(x/2,cnt+1);
        dfs(x-1,cnt+1);
    }
}