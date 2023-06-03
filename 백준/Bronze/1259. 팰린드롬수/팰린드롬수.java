import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();
            if(n==0){
                break;
            }
            StringBuilder reverse = new StringBuilder(String.valueOf(n)).reverse();
            if(reverse.toString().equals(String.valueOf(n))){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }
}