import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        Stack<Double> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if ('A' <= c && c <= 'Z') stack.push(arr[c - 'A']);
            else {
                Double pop1 = stack.pop();
                Double pop2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(pop2 + pop1);
                        break;
                    case '-':
                        stack.push(pop2 - pop1);
                        break;
                    case '*':
                        stack.push(pop2 * pop1);
                        break;
                    case '/':
                        stack.push(pop2 / pop1);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
