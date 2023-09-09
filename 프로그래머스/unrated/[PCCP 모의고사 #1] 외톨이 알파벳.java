import java.util.TreeSet;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        //앞이랑 다르면서 이미 있으면 외톨이
        boolean[] isVisited = new boolean[26];
        isVisited[input_string.charAt(0) - 'a'] = true;
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 1; i < input_string.length(); i++) {
            if (input_string.charAt(i - 1) == input_string.charAt(i)) {
                continue;
            }
            if(isVisited[input_string.charAt(i) - 'a']){
                set.add(input_string.charAt(i));
                continue;
            }
            isVisited[input_string.charAt(i) - 'a'] = true;
        }
        if (set.isEmpty()) {
            return "N";
        }
        for (Character character : set) {
            answer += character;
        }
        return answer;
    }
}
