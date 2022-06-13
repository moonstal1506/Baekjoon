class Solution {
    public int solution(int[] arr) {
        
    	//첫번째 값 저장
    	int answer = arr[0];
        
        
    	for(int i=1;i<arr.length;i++) {
    		//최대공약수
    		int gcd = gcd(answer,arr[i]);
    		//최소 공배수 두 값 곱해서 최대 공약수로 나눈것
    		answer=answer*arr[i]/gcd;
    	}
        return answer;
    }

	private int gcd(int answer, int i) {
		int max=Math.max(answer, i);
		int min=Math.min(answer, i);
		
		while(max%min!=0) {
			int r=max%min;
			max=min;
			min=r;
		}
		return min;
	}
}