import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        //입력받기
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }

        //이중포문돌면서 행,열 자리바꾸고 몇개먹을 수 있나 체크,답과 비교 원상복구
        int answer=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    char tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = tmp;
                    int num = check(arr);
                    answer = Math.max(answer,num);
                    tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = tmp;
                }
                if(i+1<n){
                    char tmp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = tmp;
                    int num = check(arr);
                    answer = Math.max(answer,num);
                    tmp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = tmp;
                }
            }
        }
        System.out.println(answer);
    }

    //연속개수구하기 행,열 답1초기화 이전과 같으면 ++아니면 1초기화 답과 비교
    private static int check(char[][] arr) {
        int answer=1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int cnt=1;
            for (int j = 1; j < n; j++) {
                if(arr[i][j]==arr[i][j-1]) cnt++;
                else cnt=1;
                answer = Math.max(answer,cnt);
            }
            cnt=1;
            for (int j = 1; j < n; j++) {
                if(arr[j][i]==arr[j-1][i]) cnt++;
                else cnt=1;
                answer = Math.max(answer,cnt);
            }
        }
        return answer;
    }
}