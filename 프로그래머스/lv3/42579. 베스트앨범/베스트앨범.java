import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    public Integer[] solution(String[] genres, int[] plays) {
        Map<String, List<Play>> music = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            List<Play> list = music.getOrDefault(genres[i], new ArrayList<>());
            list.add(new Play(i, plays[i]));
            music.put(genres[i], list);
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> musicNames = sum.keySet().stream().sorted((a, b) -> sum.get(b) - sum.get(a)).collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();
        for (String musicName : musicNames) {
            List<Play> list = music.get(musicName);
            Collections.sort(list);
            answer.addAll(list.stream().sorted().limit(2).map(play -> play.id).collect(Collectors.toList()));
        }
        return answer.toArray(new Integer[answer.size()]);

    }

    private class Play implements Comparable<Play> {
        int id;
        int play;

        public Play(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Play o) {
            if (play == o.play) {
                return id - o.id;
            }
            return o.play - play;
        }
    }
}