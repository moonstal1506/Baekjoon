import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> list = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            list.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            if (list.containsKey(discount[i])) {
                list.put(discount[i], list.get(discount[i]) - 1);
            }
        }
        if (isPossible(list)) {
            answer++;
        }

        for (int i = 10; i < discount.length; i++) {
            if (list.containsKey(discount[i - 10])) {
                list.put(discount[i - 10], list.get(discount[i - 10]) + 1);
            }
            if (list.containsKey(discount[i])) {
                list.put(discount[i], list.get(discount[i]) - 1);
            }
            if (isPossible(list)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isPossible(Map<String, Integer> list) {
        for (Integer value : list.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
}