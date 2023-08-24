import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        //order의 길이 만큼 꺼내다가 나왔어 그러면 카운트
        //다음꺼가 작으면 보조의 바로 앞에 있는지 확인
        //다음꺼가 크면 다시 꺼내면서 확인 아니면 보조에 넣어
        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        for (int n : order) {
            while (cnt < n) {
                stack.add(cnt);
                cnt++;
            }
            if (cnt == n) {
                answer++;
                cnt++;
                continue;
            }
            if (cnt > n) {
                if (stack.peek() == n) {
                    stack.pop();
                    answer++;
                    continue;
                }
                //작은데 바로 앞에 없으면 끝남
                break;
            }
        }
        return answer;
    }
}