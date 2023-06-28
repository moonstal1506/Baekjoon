import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> min = new PriorityQueue<>();
        for (String operation : operations) {
            String[] command = operation.split(" ");
            if (command[0].equals("I")) {
                int num = Integer.parseInt(command[1]);

                max.add(num);
                min.add(num);
                continue;
            }

            if (!max.isEmpty() && command[0].equals("D")) {
                int num = Integer.parseInt(command[1]);
                if (num == 1) {
                    Integer maxNum = max.poll();
                    min.remove(maxNum);
                    continue;
                }

                if (num == -1) {
                    Integer minNum = min.poll();
                    max.remove(minNum);
                }
            }
        }

        if (max.size() != 0) {
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        return answer;
    }
}