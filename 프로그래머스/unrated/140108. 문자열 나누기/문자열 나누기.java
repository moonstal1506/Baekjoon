class Solution {
    public int solution(String s) {
        int answer = 0;

        while (s.length() > 0) {
            answer++;
            int first = 1;
            int second = 0;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(0);
                if (c == s.charAt(i)) {
                    first++;
                } else {
                    second++;
                }
                if (first == second) {
                    break;
                }
            }
            s = s.substring(first + second);
        }
        return answer;
    }
}
