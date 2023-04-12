import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[] parents;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();
        int answer = 0;

        parents = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < p; i++) {
            int num = sc.nextInt();

            int gate = find(num);
            if (gate == 0) {
                break;
            }
            answer++;
            union(gate, gate - 1);
        }

        System.out.println(answer);
    }

    private static void union(int gate, int nextGate) {
        parents[find(gate)] = find(nextGate);
    }

    private static int find(int num) {
        if (parents[num] == num) {
            return num;
        }

        return parents[num] = find(parents[num]);
    }

}