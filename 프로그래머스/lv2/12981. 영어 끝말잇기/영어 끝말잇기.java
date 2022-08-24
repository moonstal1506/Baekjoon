import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int length = words.length;
        List<String> list = new ArrayList<>();
        list.add(words[0]);

        for (int i = 1; i < length; i++) {
            String word = words[i];
            String front = list.get(i-1);
            if (list.contains(word)||front.charAt(front.length()-1)!=word.charAt(0)){
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
            list.add(words[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] survey = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] solution1 = solution.solution(3, survey);
        for (int i : solution1) {
            System.out.println(i);
        }
    }
}