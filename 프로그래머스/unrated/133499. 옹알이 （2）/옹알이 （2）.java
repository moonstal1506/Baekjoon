class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            s = s.replaceAll("aya", "1")
                    .replaceAll("ye", "2")
                    .replaceAll("woo", "3")
                    .replaceAll("ma", "4");

            if(s.contains("11")||s.contains("22")||s.contains("33")||s.contains("44")){
                continue;
            }

            if(s.matches(".*[a-zA-Z].*")){
                continue;
            }

            answer++;
        }
        return answer;
    }
}