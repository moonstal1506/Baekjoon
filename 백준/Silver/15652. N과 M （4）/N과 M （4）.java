import java.util.Scanner;

//중복가능 오름차순
public class Main {

    static int[] arr = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        //n까지 수 m자리
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dfs(0,1,n,m);
        System.out.println(sb.toString());

    }

    private static void dfs(int idx,int s, int n, int m) {
        //멈춤 m만들어졌을때 숫자 찍기
        if(idx==m){
            for (int i = 0; i < idx; i++) {
                sb.append(arr[i]);
                if(i!=idx-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        //오름차순
        for(int i=s;i<=n;i++){
            arr[idx]=i;
            dfs(idx+1, i,n,m);
        }
    }
} 