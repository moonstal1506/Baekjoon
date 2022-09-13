class Solution {
    public int[] solution(int n, long left, long right) {
        int start = (int) left;
        int finish = (int) right;
        int[] answer = new int[finish - start + 1];
        int idx = 0;
        for (long i = left; i < right + 1; i++) {
            answer[idx] = Math.max((int) (i /(long) n), (int) (i % (long) n)) + 1;
            idx++;
        }
        return answer;
    }
}