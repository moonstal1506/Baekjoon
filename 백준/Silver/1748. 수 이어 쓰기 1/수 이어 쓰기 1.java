import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //1부터 1의자리 10의자리.. 길이++ 끝수 구해서 입력수보다 큰지 비교 답 누적
        int answer=0;
        for (int i = 1,len=1; i <=n; i*=10,len++) {
            int end = i*10-1;
            if(end>n) end=n;
            answer += (end - i + 1) * len;
        }
        System.out.println(answer);
    }
}