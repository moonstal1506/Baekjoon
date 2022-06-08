import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int a:d) {
        	if(budget-a>=0) {
        		budget-=a;
        		answer++;
        	}
        	
        }
        
        return answer;
    }
}