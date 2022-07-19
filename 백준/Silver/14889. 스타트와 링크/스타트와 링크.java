import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    //사람수, 능력, 팀리스트
    static int n;
    static int[][] power;
    static boolean[] check;
    static int answer=Integer.MAX_VALUE;

    public static void main(String args[]) {
        //사람수, 능력 입력받기 dfs 최소값 구하기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        power = new int[n][n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                power[i][j]=sc.nextInt();
            }
        }
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int idx,int cnt) {
        //인덱스, 조합 n/2까지, 계산
        if (cnt == n/2) {
            min();
            return;
        }

        //방문 안했으면 체크걸고 dfs 나올때 체크해제
        for (int i = idx; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(i + 1, cnt + 1);
                check[i] = false;
            }
        }
    }

    private static void min() {
        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check[i] == true && check[j] == true) {
                    a += power[i][j];
                    a += power[j][i];
                }
                if (check[i] == false && check[j] == false) {
                    b += power[i][j];
                    b += power[j][i];
                }
            }
        }
        answer=Math.min(answer, Math.abs(a-b));
    }
}