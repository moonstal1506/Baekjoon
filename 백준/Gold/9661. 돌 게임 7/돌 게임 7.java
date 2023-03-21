import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Long n = Long.parseLong(br.readLine());
        if (n % 5 == 0 || n % 5 == 2) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}