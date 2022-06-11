import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 정렬
        Arrays.sort(phone_book);
        
        //앞번호가 뒷번호의 접두어인가? startsWith
        for(int i=0;i<phone_book.length-1;i++) {
        	if(phone_book[i+1].startsWith(phone_book[i])) {
        		return false;
        	}
        }
        
        //접두어 없으면 true
        return answer;
    }
}