import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int s = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("all")) {
                s = (1 << 21) - 1;
                continue;
            }

            if (command.equals("empty")) {
                s = 0;
                continue;
            }

            int number = Integer.parseInt(st.nextToken());

            if (command.equals("add")) {
                s |= (1 << number);
                continue;
            }

            if (command.equals("remove")) {
                s &= ~(1 << number);
                continue;
            }

            if (command.equals("check")) {
                if ((s & (1 << number)) == 0) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
                continue;
            }

            if (command.equals("toggle")) {
                s ^= (1 << number);
            }
        }
        System.out.println(sb);
    }
}