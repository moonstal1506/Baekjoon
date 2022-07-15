import java.util.Scanner;

public class Main {

    //배열 숫자 담아둘곳,
    static int[] arr = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        //n까지 수 m자리
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //인덱스, 선택수
        dfs(1,0,n,m);
        System.out.println(sb.toString());

    }

    private static void dfs(int idx, int s, int n, int m) {
        //멈춤 m만들어졌을때
        if(s==m){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]);
                if(i!=idx-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        // 선택한다 선택하지 않는다, 더이상 선택할 것 없으면 리턴
        if(idx>n) return;
        arr[s] = idx;
        dfs(idx+1,s+1,n,m);
        dfs(idx+1,s,n,m);
    }

}