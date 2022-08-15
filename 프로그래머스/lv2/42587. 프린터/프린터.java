import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        //대기목록 담기
        Queue<Printer> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Printer(priorities[i], i));
        }
        //비어있지 않을 때까지 돌고 앞에꺼 꺼내서 가장 큰지 확인 작으면 다시 뒤로 크면 ++ 찾았으면 멈춰
        while (!q.isEmpty()) {
            Printer printer = q.poll();
            if (q.stream().anyMatch(i -> i.priority > printer.priority)) {
                q.add(printer);
            }else {
                answer++;
                if(printer.location==location) break;
            }
        }
        return answer;
    }

    static class Printer{
        int priority;
        int location;

        public Printer(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}