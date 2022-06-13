import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String s) {
        List<Integer> list = new ArrayList<Integer>();
        
        String[] split = s.split(" ");
        
        for(String str:split) {
        	list.add(Integer.parseInt(str));
        	
        }
        
        
        return Collections.min(list)+" "+Collections.max(list);
    }
}