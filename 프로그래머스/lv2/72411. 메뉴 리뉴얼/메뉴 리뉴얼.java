import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {
	
	HashMap<String,Integer> map = new HashMap<>();
	
    public String[] solution(String[] orders, int[] course) {
       
        ArrayList<String> answerList = new ArrayList<>();
        
        //order 정렬 해서 다시 넣기
        for(int i=0;i<orders.length;i++) {
        	char[] arr = orders[i].toCharArray();
        	Arrays.sort(arr);
        	orders[i]=String.valueOf(arr);
        }
        
        //길이만큼의 오더조합 만들기
        for(int len:course) {
        	for(String order:orders) {
        		comb("",order,len);
        	}
        	//조합이 있으면 맵의 최대값 찾고 1보다 클때만 맵의 키로 값찾아서 맥스인지 확인해서 답에 넣어
            if(!map.isEmpty()) {
            	ArrayList<Integer> list = new ArrayList<>(map.values());
            	int max=Collections.max(list);
            	
            	if(max>1) {
            		for(String comb:map.keySet()) {
            			if(map.get(comb)==max) {
            				answerList.add(comb);
            			}
            		}
            		map.clear();
            	}
            }
        }
        
        //정렬하고 배열에 넣기
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for(int i=0;i<answerList.size();i++) {
        	answer[i]=answerList.get(i);
        }
        return answer;
    }
    
    //조합만들기 현재,남은거,길이  / 붙이고 자르고 빼줌 / 길이0이면 조합을 이름으로 해쉬맵넣고+1
	private void comb(String comb, String rest, int len) {
		if(len==0) {
			map.put(comb, map.getOrDefault(comb, 0)+1);
			return;
		}
		
		for(int i=0;i<rest.length();i++) {
			comb(comb+rest.charAt(i),rest.substring(i+1),len-1);
		}
	}
}