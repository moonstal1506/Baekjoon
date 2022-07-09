import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = a; i <= b; i++) {
            if(isPrime(i)) System.out.println(i);
        }
    }

    private static boolean isPrime(int num) {
        if(num==1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}
