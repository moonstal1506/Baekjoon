class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long P = Long.parseLong(p);
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            long T = Long.parseLong(t.substring(i, i + p.length()));
            if (T <= P) {
                answer++;
            }
        }
        return answer;
    }
}
