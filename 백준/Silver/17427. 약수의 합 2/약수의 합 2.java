import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum=0;
        for (int i = 1; i <= n; i++) {
            sum+= i*(n/i);//약수 몇개?(n/i)
        }
        System.out.println(sum);
    }
}
