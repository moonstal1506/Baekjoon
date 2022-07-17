import java.util.Arrays;
import java.util.Scanner;

//중복가능 오름차순
public class Main {
    //n,m,숫자담을배열, 사용체크, 결과배열
    private static int n,m;
    private static int[] arr;
    private static int[] ans;
    private static StringBuilder sb= new StringBuilder();


    public static void main(String[] args) {
        //n까지 수 m자리
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        //배열 생성,숫자담기, 정렬후 dfs호출
        arr = new int[n];
        ans = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb.toString());

    }

    private static void dfs(int idx) {
        //멈춤 m만들어졌을때 결과 숫자 찍기
        if(idx==m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
                ans[idx]=arr[i];
                dfs(idx+1);
            }
        }
}