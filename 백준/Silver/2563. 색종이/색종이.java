import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] isVisited = new boolean[100][100];
        int answer = 0;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (isVisited[j][k]) {
                        continue;
                    }
                    isVisited[j][k] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}