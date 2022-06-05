class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int p=0;
        int y=0;
        String lowerCase = s.toLowerCase();
        for(int i=0;i<s.length();i++) {
        	if(lowerCase.charAt(i)=='y') {
        		y++;
        	}
        	if(lowerCase.charAt(i)=='p') {
        		p++;
        	}
        }
        if(p==y) return true;
        return answer;
    }
}