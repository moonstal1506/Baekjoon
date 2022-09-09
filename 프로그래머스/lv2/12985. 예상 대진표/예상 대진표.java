class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        while (true) {
            answer++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            if (a==b) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(8, 4, 7);
        System.out.println(solution1);
    }
}