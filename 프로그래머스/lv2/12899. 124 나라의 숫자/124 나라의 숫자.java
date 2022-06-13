class Solution {
    public String solution(int n) {
    	
        String answer = "";
        
        //3으로 나눴을 때 나머지 인덱스 124나라 숫자
        String[] arr= {"4","1","2"};
        
    	//나머지 구하고 나눠 나머지가 0이면 숫자하나 빼기 앞에 나머지로 나온 수 붙이기
        while(n!=0) {
        	int r= n%3;
        	n/=3;
        	if(r==0)n--;
        	answer=arr[r]+answer;
        }
        return answer;
    }
}