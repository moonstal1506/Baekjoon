import java.util.Arrays;

class Solution {
    String begin;
    String target;
    String[] words;
    boolean[] isVisited;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        isVisited = new boolean[words.length];

        if (!Arrays.stream(words).anyMatch(word -> word.equals(target))) {
            return 0;
        }
        dfs(begin, 0);
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }

    private void dfs(String word, int n) {
        if (word.equals(target)) {
            answer = Math.min(answer, n);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            if (isVisited[i]) {
                continue;
            }
            for (int j = 0; j < target.length(); j++) {
                if (words[i].charAt(j) != word.charAt(j)) {
                    cnt++;
                }
                if (cnt > 1) {
                    break;
                }
            }
            if (cnt == 1) {
                isVisited[i] = true;
                dfs(words[i], n + 1);
                isVisited[i] = false;
            }
        }
    }
}