import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3},
                new String[][]{{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}});
        System.out.println(Arrays.toString(solution1));
    }
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        int[] result = new int[photo.length];
        int idx = 0;
        for (String[] names : photo) {
            int score = 0;
            for (int i = 0; i < names.length; i++) {
                score += map.getOrDefault(names[i], 0);
            }
            result[idx++] = score;
        }
        return result;
    }
}