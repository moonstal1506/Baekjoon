class Solution {
    public int solution(int n, int m, int[] section) {
        //섹션 하나에 더하기 m해서 작은 애들 통과시켜 
        int answer = 0;
        int max = 0;
        for (int number : section) {
            if (number < max) {
                continue;
            }
            answer++;
            max = number + m;
        }
        return answer;
    }
}