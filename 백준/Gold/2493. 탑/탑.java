import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        //n까지
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek().height >= height) {
                    //크면 남기고 얘 인덱스 출력
                    sb.append(stack.peek().index + " ");
                    break;
                } else {
                    //앞이 나보다 작으면 계속 빼, 그러다 나보다 큰애 없으면 스택 0됨
                    stack.pop();
                }
            }

            //스택 0됨 그럼 0찍고
            if (stack.isEmpty()) {
                sb.append(0 + " ");
            }

            //나 집어넣기
            stack.add(new Tower(height, i));
        }
        System.out.println(sb);
    }
}

class Tower {
    int height;
    int index;

    public Tower(int height, int index) {
        this.height = height;
        this.index = index;
    }
}