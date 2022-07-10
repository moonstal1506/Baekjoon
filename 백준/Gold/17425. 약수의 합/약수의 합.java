import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //배열 맥스로 만들어 놓고 1초기화 약수 합구해 배열에 담아두기
        final int MAX = 1000000;
        long[] divisor =new long[MAX+1];

        for (int i = 1; i <= MAX; i++) {
            divisor[i]=1;
        }

        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; j * i <= MAX; j++) {
                divisor[i*j]+=i;//i를 약수로 갖고 있다.
            }
        }

        //약수 합의 합 배열 담기
        long[] sum = new long[MAX+1];
        for (int i = 1; i <= MAX; i++) {
            sum[i]=sum[i-1]+divisor[i];
        }

        //입력 출력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            int num = Integer.parseInt(bf.readLine());
            bw.write(sum[num]+"\n");
        }
        bw.flush();
    }
}
