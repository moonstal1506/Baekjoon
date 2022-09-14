import java.util.Arrays;
import java.util.LinkedHashSet;

class Solution {
    public int[] solution(String s) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        String s1 = s.substring(2, s.length() - 2);
        String[] split = s1.split("\\},\\{");
        Arrays.sort(split, (a, b) -> (a.length() - b.length()));

        for (String str : split) {
            String[] split2 = str.split(",");
            for (String str2 : split2) {
                set.add(Integer.parseInt(str2));
            }
        }

        int n = set.size();
        int[] answer = new int[n];

        int cnt = 0;
        for (Integer num : set) {
            answer[cnt++] = num;
        }
        return answer;
    }
}