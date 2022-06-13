class Solution {
    public String solution(String s) {
    	StringBuilder sb = new StringBuilder();
    	
    	//소문자로 바꾸고 다 잘라
    	String[] arr = s.toLowerCase().split("");
    	
    	//첫글자 true
    	boolean first=true;
    	
    	//배열 돌려 첫글자인지 확인 대문자 바꾸기 
    	for(String str:arr) {
    		if(first) {
    			sb.append(str.toUpperCase());
    		}else {
    			sb.append(str);
    		}
    		//지금 값 공백?
            if(str.equals(" ")) {
            	first=true;
            }else {
            	first=false;
            }
    	}

        return sb.toString();
    }
}