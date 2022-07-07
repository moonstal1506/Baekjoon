import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        System.out.println(gcr(max,min));
        System.out.println(max*min/gcr(max,min));
    }

    private static int gcr(int a, int b) {
        if(a%b==0) return b;
        return gcr(b,a%b);
    }
}
