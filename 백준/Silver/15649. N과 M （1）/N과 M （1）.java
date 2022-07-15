import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //dfs 숫자사용체크, 배열 숫자 담아둘곳,
    static boolean[] check = new boolean[10];
    static int[] arr = new int[10];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        //n까지 수 m자리
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dfs(0,n,m);
        System.out.println(sb.toString());

    }

    private static void dfs(int idx, int n, int m) {
        //멈춤 m만들어졌을때 숫자 찍기 StringBuilder사용
        if(idx==m){
            for (int i = 0; i < idx; i++) {
                sb.append(arr[i]);
                if(i!=idx-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        // 1부터 n까지 돌려 사용확인후 숫자 담아 ,dfs, 나올때 체크풀기
        for(int i=1;i<=n;i++){
            if(check[i]==true) continue;
            check[i] = true;
            arr[idx]=i;
            dfs(idx+1,n,m);
            check[i] = false;
        }
    }
}