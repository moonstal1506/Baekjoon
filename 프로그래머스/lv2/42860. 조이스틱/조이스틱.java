class Solution {
    public int solution(String name) {
        int min = name.length() - 1;
        int count = 0;

        for (int i = 0; i < name.length(); i++) {
            count += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int idx = i + 1;
            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }
            min = Math.min(min, Math.min(i * 2 + name.length() - idx, (name.length() - idx) * 2 + i));
        }
        count += min;

        return count;
    }
}