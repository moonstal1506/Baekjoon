class Solution {
    public int solution(String word) {
        String s = "AEIOU";
        int[] arr = {781, 156, 31, 6, 1};
        int len = word.length();
        int answer = word.length();

        for (int i = 0; i < len; i++) {
            answer += arr[i] * s.indexOf(word.charAt(i));
        }
        return answer;
    }
}