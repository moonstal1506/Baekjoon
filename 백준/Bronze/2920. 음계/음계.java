import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            for (int i = 2; i <= 8; i++) {
                n = sc.nextInt();
                if (n != i) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");

        } else if (n == 8) {
            for (int i = 7; i >= 1; i--) {
                n = sc.nextInt();
                if (n != i) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}