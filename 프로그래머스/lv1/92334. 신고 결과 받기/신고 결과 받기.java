import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //중복제거 해쉬셋 신고결과 넣기
        HashSet<String> result=new HashSet<>();
        for(String str:report) result.add(str);
        
        
        //해쉬맵 신고받은사람키, 신고자 값을 어레이리스트, 공백으로 나눠
        HashMap<String, ArrayList<String>> reportMap= new HashMap<>();
        for(String str:result) {
        	String[] split = str.split(" ");
        	
        	//어레이리스트에 넣을 건데 신고받은사람꺼 가져와 없으면 null 새로 생성
        	ArrayList<String> reporters = reportMap.getOrDefault(split[1], null);
        	if(reporters==null) reporters = new ArrayList<>();
        	
        	//있으면 신고자 넣기 맵에 put
        	reporters.add(split[0]);
        	reportMap.put(split[1], reporters);
        }

        //이름키 메일받는 횟수 값으로 해쉬맵
        HashMap<String, Integer> countMap= new HashMap<>();
        
        //신고해쉬맵에서 신고자 어레이리스트 (값) 돌려 사이즈체크k, 신고자리스트 이름으로 횟수 증가시켜
        for(ArrayList<String> list:reportMap.values()) {
        	if(list.size()>=k) {
        		for(String reporter:list)
        		countMap.put(reporter, countMap.getOrDefault(reporter, 0)+1);
        	}
        }
        
        //횟수 해쉬맵에서 아이디리스트키로 가져와 답에 담아줌
        for(int i=0;i<id_list.length;i++) {
        	answer[i]=countMap.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}