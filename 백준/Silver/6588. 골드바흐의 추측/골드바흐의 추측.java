import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {

        //에라토스테네스체 배열만들기 0,1은 소수 아님, 소수담는 리스트
        boolean[] check = new boolean[MAX+1];
        check[0] = check[1] = true;
        ArrayList<Integer> arr = new ArrayList<>();

        //2부터 제곱이 맥스일때까지 돌면서 소수판별
        //처음-> 소수담기, 배수 제거
        for (int i = 2; i * i <= MAX; i++) {
            if(check[i]==true) continue;
            arr.add(i);
            for(int j=i+i;j<=MAX;j+=i){
                check[j] = true;
            }
        }

        //반복돌려 0이면 멈춰, 소수크기만큼돌려 꺼내서 뺀값이 소수면 출력,1부터시작이유 0은 2라서
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            for (int i = 1; i < arr.size(); i++) {
                Integer prime = arr.get(i);
                if(check[n-prime]==false){
                    System.out.println(n+" = "+prime+" + "+(n-prime));
                    break;
                }
            }
        }
    }
}