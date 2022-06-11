import java.util.HashSet;
import java.util.Iterator;

class Solution {
	
	HashSet<Integer> set = new HashSet<>();
	
    public int solution(String numbers) {
        int answer = 0;
        
        //숫자조합만들기 처음 ("",넘버)넘겨
        recursive("",numbers);
        
        //소수개수세기 셋 돌면서 소수확인 answer++
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            if(isPrime(iterator.next())) {
            	answer++;
            }
        }
        return answer;
    }

    //조합만들기  ""아닐때만 set에 추가해줘 문자돌면서 재귀넘기기
	private void recursive(String comb, String numbers) {
		if(!comb.equals("")) {
			set.add(Integer.parseInt(comb));
		}
		for(int i=0;i<numbers.length();i++) {
			recursive(comb+numbers.charAt(i),numbers.substring(0,i)+numbers.substring(i+1));
		}
		
	}
    
    //소수확인 0,1 소수아님, 숫자의 제곱근까지만 돌고 2부터 나눠봐 나눠지면 false;
	private boolean isPrime(Integer num) {
		if(num==0||num==1) {
			return false;
		}
		
		for(int i=2;i<=(int)Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}