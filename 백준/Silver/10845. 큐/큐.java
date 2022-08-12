import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int last = 0;
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            switch (command) {
                case "push":
                    last = sc.nextInt();
                    q.add(last);
                    break;
                case "pop":
                    if (q.isEmpty()) sb.append(-1+"\n");
                    else sb.append(q.poll()+"\n");
                    break;
                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    if (q.isEmpty()) sb.append(1+"\n");
                    else sb.append(0+"\n");
                    break;
                case "front":
                    if (q.isEmpty()) sb.append(-1+"\n");
                    else sb.append(q.peek()+"\n");
                    break;
                case "back":
                    if (q.isEmpty()) sb.append(-1+"\n");
                    else sb.append(last+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
