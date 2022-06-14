class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum =brown+yellow;
        
        //약수찾기 가로세로 3이상,노랑가능?
        for(int i=3;i<sum;i++) {
        	int j=sum/i;
        	if((i-2)*(j-2)==yellow) {
        		answer[0]=Math.max(i, j);
        		answer[1]=Math.min(i, j);
        		return answer;
        	}
        }
        
        return answer;
    }
}