import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1;j<numbers.length; j++){
                int num = numbers[i]+numbers[j];
                if (!list.contains(num)){
                	list.add(num);
                }
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}