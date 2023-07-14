import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int k = 0; k < elements.length; k++) {
                int num = 0;
                for (int j = 0; j < i; j++) {
                    if (k + j <= elements.length - 1) {
                        num += elements[k + j];
                    } else {
                        num += elements[k + j - elements.length];
                    }
                }
                set.add(num);
            }
        }
        return set.size();
    }
}