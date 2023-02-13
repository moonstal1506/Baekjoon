import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int w;
    static int L;
    static Queue<Integer> bridge = new LinkedList<>();
    static Queue<Integer> truck = new LinkedList<>();
    static int sum;
    static int time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        L = sc.nextInt();
        w = sc.nextInt();

        for (int i = 0; i < L; i++) {
            bridge.add(0);
        }

        for (int i = 0; i < n; i++) {
            truck.add(sc.nextInt());
        }

        while (!bridge.isEmpty()) {
            sum -= bridge.poll();
            time++;
            
            if(!truck.isEmpty()){
                if (sum + truck.peek() <= w) {
                    int weight = truck.poll();
                    sum += weight;
                    bridge.add(weight);
                } else {
                    bridge.add(0);
                }
            }
        }
        
        System.out.println(time);
    }
}
