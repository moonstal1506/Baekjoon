import java.util.Arrays;
import java.util.Scanner;

//중복가능 오름차순
public class Main {
    //n,m,숫자담을배열, 사용체크, 결과배열
    private static int n,m;
    private static int[] arr;
    private static boolean[] check;
    private static int[] ans;


    public static void main(String[] args) {
        //n까지 수 m자리
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        //배열 생성,숫자담기, 정렬후 dfs호출
        arr = new int[n];
        check = new boolean[n];
        ans = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0);

    }

    private static void dfs(int idx) {
        //멈춤 m만들어졌을때 결과 숫자 찍기
        if(idx==m) {
            for (int i = 0; i < m; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }

        //숫자개수만큼 돌면서 안간곳 체크해주고 결과에 숫자 담고 dfs 나올때 체크풀기
        for (int i = 0; i < n; i++) {
            if(!check[i]){
                check[i] = true;
                ans[idx]=arr[i];
                dfs(idx+1);
                check[i] = false;
            }
        }
    }
} 