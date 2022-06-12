import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        
        //해쉬맵 정보문자열-키, 점수-어레이리스트
        HashMap<String, ArrayList<Integer>> map= new HashMap<>();
        
        //인포 잘라 담고 정보별로 -추가해서 배열만듦 점수정수로
        for(String str:info) {
        	String[] infos = str.split(" ");
        	String[] lang= {infos[0],"-"};
        	String[] position= {infos[1],"-"};
        	String[] ex= {infos[2],"-"};
        	String[] food= {infos[3],"-"};
        	int score=Integer.parseInt(infos[4]);
        	
        	//포문돌면서 배열만들고 공백으로 조인해서 키로씀 맵에서 찾고없으면 어레이리스트 생성 점수넣기 맵에 풋
        	for(String l:lang){
        		for(String p:position) {
	        		for(String e:ex) {
	        			for(String f:food) {
	        				String[] keys= {l,p,e,f};
	        				String key=String.join(" ", keys);
	        				ArrayList<Integer> scoreList = map.getOrDefault(key, new ArrayList<>());
	        				scoreList.add(score);
	        				map.put(key, scoreList);
	        			}
	        		}
        		}
        	}
        }
        
        //맵 값 오름차순
        for(ArrayList<Integer>list:map.values()) {
        	Collections.sort(list);
        }
        
        //쿼리돌면서 잘라 키랑 값 만들기 해쉬맵에서 키로 값 찾고 이분탐색하고 크기에서 왼쪽 빼준게 답
        int[] answer = new int[query.length];
        for(int i=0;i<query.length;i++) {
        	String[] q = query[i].split(" and ");
        	String[] split = q[3].split(" ");
        	String[] keys = {q[0],q[1],q[2],split[0]};
        	String key = String.join(" ", keys);
        	int score=Integer.parseInt(split[1]);
        	
        	if(map.containsKey(key)) {
        		ArrayList<Integer> list = map.get(key);
        		int left=0;
        		int right=list.size();
        		while(left<right) {
        			int mid=(left+right)/2;
        			if(list.get(mid)>=score) {
        				right=mid;
        			}else {
        				left=mid+1;
        			}
        		}
        		answer[i]=list.size()-left;
        	}
        }
        return answer;
    }
}