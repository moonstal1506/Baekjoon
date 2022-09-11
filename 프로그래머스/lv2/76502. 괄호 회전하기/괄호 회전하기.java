import java.util.Stack;

class Solution {
    Stack<Character> stack = new Stack<>();

    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (check(s, n)) {
                answer++;
            }
            s = s.substring(1, s.length()) + s.charAt(0);
        }
        return answer;
    }

    private boolean check(String s, int n) {
        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == '{' || s.charAt(j) == '[' || s.charAt(j) == '(') {
                stack.add(s.charAt(j));
            } else {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '{' && s.charAt(j) != '}') return false;
                if (stack.peek() == '[' && s.charAt(j) != ']') return false;
                if (stack.peek() == '(' && s.charAt(j) != ')') return false;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}