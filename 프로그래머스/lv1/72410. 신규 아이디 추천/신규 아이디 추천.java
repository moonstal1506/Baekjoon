class Solution {
    public String solution(String new_id) {
        // 1. 소문자
        String answer = new_id.toLowerCase();
        
        // 2. 예외 문자 제거
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        
        // 3. 마침표(.)가 2번 이상 연속 .
        answer = answer.replaceAll("[.]{2,}", ".");
        
        // 4. 마침표(.)가 처음이나 끝에 위치한다면 제거
        answer = answer.replaceAll("^[.]{1}", "");
        
        // 5. 빈 문자열"a"
        if(answer.isEmpty())  answer += "a";
        
        // 6. 16자 이상 앞15까지,마침표(.)가 끝에 위치한다면 제거
        if(answer.length() >= 16) answer = answer.substring(0, 15);
        answer = answer.replaceAll("[.]{1}$", "");
        
        // 7. 2자 이하 마지막 문자 길이가 3이 될 때까지
        while (answer.length() < 3) {
			answer += answer.charAt(answer.length() - 1);
		}

        return answer;
    }
}