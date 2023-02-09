import java.util.Scanner;

public class Main {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        recur(0, 0);
    }

    private static void recur(int cnt, int number) {
        if (cnt == n) {
            System.out.println(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            int tmp = number * 10 + i;
            if (isPrime(tmp)) {
                recur(cnt + 1, tmp);
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
