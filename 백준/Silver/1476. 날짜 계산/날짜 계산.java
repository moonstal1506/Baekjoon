import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력 3개
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int year=0;
        int e=1,s=1,m=1;

        //년도 같아질때까지 돌아 ++ 3곳+1, 맥스값 되면 1로 초기화
        while(true){
            year++;
            if (E == e && S == s && M == m) {
                System.out.println(year);
                break;
            }
            e++;s++;m++;
            if(e==16) e=1;
            if(s==29) s=1;
            if(m==20) m=1;
        }


    }

}