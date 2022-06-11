import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        //해쉬맵 옷 종류별 카운트
        for(String[] clothe:clothes) {
        	map.put(clothe[1], map.getOrDefault(clothe[1],0)+1);
        }
        
        //옷종류+안입는 경우로 경우의수
        for(int cnt:map.values()) {
        	answer*=cnt+1;
        }
        
        //입지 않은경우 빼주기
        return answer-1;
    }
}