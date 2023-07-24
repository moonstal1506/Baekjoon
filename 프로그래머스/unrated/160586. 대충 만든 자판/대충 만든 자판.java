import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap();
        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                if (map.containsKey(keys.charAt(i))) {
                    map.put(keys.charAt(i), Math.min(i + 1, map.get(keys.charAt(i))));
                } else {
                    map.put(keys.charAt(i), i + 1);
                }
            }
        }
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                if (map.containsKey(targets[i].charAt(j))) {
                    answer[i] += map.get(targets[i].charAt(j));
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}