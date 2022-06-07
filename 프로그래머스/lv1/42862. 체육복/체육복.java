import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //잃어버린애들 빼주기, 정렬
    	int answer = n-lost.length;
    	Arrays.sort(lost);
    	Arrays.sort(reserve);
    	
        //같은사람일경우 제외,++
    	for(int i=0;i<lost.length;i++) {
    		for(int j=0;j<reserve.length;j++) {
    			if(lost[i]==reserve[j]) {
    				lost[i]=-1;
    				reserve[j]=-1;
    				answer++;
    				break;
    			}
    		}
    	}
        //앞뒤에서 받을 수 있는 경우,준사람 제외,++
    	for(int i=0;i<lost.length;i++) {
    		for(int j=0;j<reserve.length;j++) {
    			if(lost[i]+1==reserve[j]||lost[i]-1==reserve[j]) {
    				reserve[j]=-1;
    				answer++;
    				break;
    			}
    		}
    	}
        
        return answer;
    }
}
