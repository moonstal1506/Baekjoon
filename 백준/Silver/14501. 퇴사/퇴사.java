import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //남은 날짜, 상담기간, 돈,최대값
    static int n;
    static int[] day;
    static int[] pay;
    static int answer=0;

    public static void main(String args[]) {
        //남은 날짜, 상담기간, 돈, dsf(날짜,합)
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        day = new int[n];
        pay = new int[n];

        for (int i = 0; i < n; i++) {
            day[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        dfs(0,0);
        System.out.println(answer);
    }

    //퇴사날짜에 돈최대비교, 퇴사날짜 넘으면리턴, 상담 한다 안한다
    private static void dfs(int today, int sum) {
        if(today==n) {
            answer = Math.max(answer, sum);
            return;
        }
        if(today>n) return;
        dfs(today+day[today],sum+pay[today]);
        dfs(today+1,sum);
    }
}