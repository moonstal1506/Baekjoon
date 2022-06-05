class Solution {
    public int solution(int n) {
        int answer = 0;
//        2부터 n까지 flag i를 j로나눈게 0 소수아님 멈춰 소수면++
        for(int i=2;i<=n;i++) {
        	boolean flag=true;
        	for(int j=2;j<=Math.sqrt(i);j++) {
        		if(i%j==0) {
        			flag=false;
        			break;
        		}
        	}
        	if(flag) {
    			answer++;
    		}
        }
        return answer;
    }
}