import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    //부등호 수, 부등호 배열 최대9, 답배열, 체크 숫자
    static int n;
    static char[] signs;
    static boolean[] check;
    static List<String> list = new ArrayList<>();

    public static void main(String args[]) {
        //부등호수, 부등호 입력, dfs(인덱스,숫자조합),정렬해서 최대최소
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        signs = new char[n];
        check = new boolean[10];
        for (int i = 0; i < n; i++) {
            signs[i]= sc.next().charAt(0);
        }
        dfs(0,"");
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    //인덱스 부등호개수보다 하나크면 멈춰 답추가
    //0~9까지 안갔고 인덱스0 또는 부등호 비교 참이면 체크걸고 dfs, 나올때 체크 풀기
    private static void dfs(int idx,String num) {
        if (idx == n + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if(check[i]) continue;
            if(idx==0 || compare(num.charAt(idx-1), (char)(i+'0'), signs[idx-1])){
                check[i] = true;
                dfs(idx+1,num+i);
                check[i] = false;
            }
        }
    }

    //문자 2개 부등호 비교
    private static boolean compare(char a, char b, char sign) {
        if (sign == '<') return a<b;
        if (sign == '>') return a>b;
        return false;
    }

}