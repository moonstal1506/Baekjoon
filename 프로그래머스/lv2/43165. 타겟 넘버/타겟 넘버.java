class Solution {
	private int answer = 0;
	private int[] numbers;
	private int target;
	
	
    public int solution(int[] numbers, int target) {
        
        //클래스 변수로 만들어 두기
        this.numbers=numbers;
        this.target=target;
        
        //dfs호출
        dfs(0,0);
        
        return answer;
    }

    //인덱스1증가, sum에 값 더하기/빼기, 탈출은 배열길이 그때 답인지 확인++
	private void dfs(int i, int sum) {
		if(i==numbers.length) {
			if(target==sum) {
				answer++;
			}
			return;
		}
		
		dfs(i+1,sum+numbers[i]);
		dfs(i+1,sum-numbers[i]);
	}
}