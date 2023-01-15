import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] kakaos = solution.solution("KAKAO");
        for (int kakao : kakaos) {
            System.out.println("kakao = " + kakao);
        }
    }

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf((char) ('A' + i)));
        }

        for (int i = 0; i < msg.length(); i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                if(msg.substring(i).startsWith(list.get(j))) {
                    i += list.get(j).length()-1;
                    answer.add(j+1);
                    if(i+1 < msg.length())
                        list.add(list.get(j)+msg.charAt(i+1));
                    break;
                }
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}