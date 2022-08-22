import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = {3, 2, 1, 0, 1, 2, 3};
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        int n = survey.length;
        for (int i = 0; i < n; i++) {
            int choice = choices[i];
            String[] s = survey[i].split("");
            if (choice < 4) {
                map.put(s[0], map.getOrDefault(s[0],0) + score[choice-1]);
            }else {
                map.put(s[1],  map.getOrDefault(s[1],0) + score[choice-1]);
            }
        }
        answer += map.getOrDefault("R",0) >= map.getOrDefault("T",0) ? "R" : "T";
        answer += map.getOrDefault("C",0) >= map.getOrDefault("F",0) ? "C" : "F";
        answer += map.getOrDefault("J",0) >= map.getOrDefault("M",0) ? "J" : "M";
        answer += map.getOrDefault("A",0) >= map.getOrDefault("N",0) ? "A" : "N";

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String solution1 = solution.solution(survey, choices);
        System.out.println(solution1);
    }
}