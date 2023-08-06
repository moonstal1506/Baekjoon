import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        //맵써서 key의 개수가 같으면 answer++
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            a.put(topping[i], a.getOrDefault(topping[i], 0) + 1);
        }
        for (int i = 0; i < topping.length; i++) {
            int t = topping[i];
            a.put(t, a.get(t) - 1);
            if(a.get(t)==0){
                a.remove(t);
            }
            b.put(t, a.getOrDefault(t, 0) + 1);
            if (a.size() == b.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}