import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        //정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
       
        //반복돌려 같은지 확인 다를때 답
        int i=0;
        for(;i<completion.length;i++) {
        	if(!participant[i].equals(completion[i])) {
        		return participant[i];
        	}
        }
        
        //반복 끝 마지막남은사람이 답
        return participant[i];
    }
}