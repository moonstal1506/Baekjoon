import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static Queue<Calculator> q;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            visited = new boolean[10000];
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (A == B) {
                System.out.println();
                continue;
            }
            q = new LinkedList<>();
            q.add(new Calculator(A, ""));
            visited[A] = true;

            while (!q.isEmpty()) {
                Calculator calculator = q.poll();
                if (calculator.number == B) {
                    System.out.println(calculator.history);
                    break;
                }

                int d = calculator.d();
                int s = calculator.s();
                int l = calculator.l();
                int r = calculator.r();

                check(calculator, d, "D");
                check(calculator, s, "S");
                check(calculator, l, "L");
                check(calculator, r, "R");
            }
        }
    }

    private static void check(Calculator calculator, int num, String command) {
        if (!visited[num]) {
            visited[num] = true;
            q.add(new Calculator(num, calculator.history + command));
        }
    }

    static class Calculator {

        int number;
        String history;

        public Calculator(int number, String history) {
            this.number = number;
            this.history = history;
        }

        public int d() {
            return number * 2 % 10000;
        }

        public int s() {
            if (number == 0) {
                return 9999;
            }
            return number - 1;
        }

        public int l() {
            return number % 1000 * 10 + number / 1000;
        }

        public int r() {
            return number / 10 + number % 10 * 1000;
        }
    }
}