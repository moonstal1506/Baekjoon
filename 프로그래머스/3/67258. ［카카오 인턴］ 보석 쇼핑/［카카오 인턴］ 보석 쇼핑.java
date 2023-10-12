import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int distance = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int n = gems.length;

        for (String s : gems) {
            set.add(s);
        }

        while (true) {
            if (set.size() == map.size()) {
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if (right == n) {
                break;
            } else {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (map.size() == set.size()) {
                if (right - left < distance) {
                    distance = right - left;
                    start = left + 1;
                    end = right;
                }
            }
        }
        answer[0] = start;
        answer[1] = end;
        return answer;
    }
}