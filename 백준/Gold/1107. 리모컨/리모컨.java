import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static boolean[] btn = new boolean[10];


    public static void main(String[] args) throws IOException {
        //입력 이동, 고장개수, 고장번호, 배열에 체크
        Scanner sc = new Scanner(System.in);
        int channel = sc.nextInt();
        int broken = sc.nextInt();
        for (int i = 0; i < broken; i++) {
            int x= sc.nextInt();
            btn[x]=true;
        }

        //초기값 번호 입력 안했을때 절댓값
        int answer= Math.abs(channel-100);

        //반복돌면서 0부터 갈수있는지 갈수있으면 길이구해줘 아님0
        for (int i = 0; i < 1000000; i++) {
            int len = isPossible(i);
            //0보다 크면 갈수있음 가야할 번호에 가능번호 빼준거 절댓값 답:누른거+이동 최소
            if(len>0){
                answer = Math.min(answer, Math.abs(channel - i) + len);
            }
        }
        System.out.println(answer);
    }

    private static int isPossible(int num) {
        if(num==0){
            if(btn[0]) return 0;
            else return 1;
        }
        int len=0;
        while(num>0){
            if(btn[num%10]) return 0;
            else len++;
            num/=10;
        }
        return len;
    }
}