class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int bitCount = Integer.bitCount(n);
        while(true) {
        	n++;
        	int bitCount2= Integer.bitCount(n);
        	if(bitCount==bitCount2) break;
        }
        
        return n;
    }
}