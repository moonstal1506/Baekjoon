import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt=1;
        int num=666;
        while (n!=cnt){
            num++;
            if(String.valueOf(num).contains("666")){
                cnt++;
            }
        }
        System.out.println(num);
    }
}