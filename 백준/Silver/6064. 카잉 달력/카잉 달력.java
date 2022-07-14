import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;

            //앞에꺼 만족시키고 뒤에꺼 나머지 구한게 답일 때 출력
            boolean flag=true;
            for (int j = x; j < M * N; j+=M) {
                if(j%N==y) {
                    System.out.println(j+1);
                    flag=false;
                    break;
                }
            }
            if(flag) System.out.println(-1);
        }

    }

}