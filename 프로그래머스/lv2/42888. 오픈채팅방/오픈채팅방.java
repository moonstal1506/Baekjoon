import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] solution(String[] record) {
        int n = record.length;
        HashMap<String, String> store = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = record[i].split(" ");
            if(split[0].equals("Leave")) continue;
            store.put(split[1], split[2]);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = record[i].split(" ");
            switch (split[0]){
                case "Enter":
                    list.add(store.get(split[1])+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add(store.get(split[1])+"님이 나갔습니다.");
                    break;
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String[] arr = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
//        String[] answer = solution.solution(arr);
//        for (String s : answer) {
//            System.out.println(s);
//        }
//    }
}