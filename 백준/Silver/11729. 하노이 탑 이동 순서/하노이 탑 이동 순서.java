import java.util.Scanner;

public class Main {

    static int cnt =0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(n,1,2,3);
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int start, int via, int to) {
        if (n == 1) {
            move(start, to);
        }else {
            hanoi(n-1,start,to,via);
            move(start,to);
            hanoi(n-1,via,start,to);
        }
    }

    private static void move(int start, int to) {
        sb.append(start).append(" ").append(to).append("\n");
        cnt++;
    }
}