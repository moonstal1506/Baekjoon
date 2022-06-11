import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        //for문 돌려 개발에 필요한 날짜구해
        for(int i=0;i<progresses.length;i++) {
        	double days=(100-progresses[i])/(double)speeds[i];
        	double day = Math.ceil(days);
        	
        	//for문 인덱스 뒤부터 함께 배포 가능한 인덱스 찾기(날짜*속도)더한게 100안되면 같이 못해
        	int j=i+1;
        	for(;j<progresses.length;j++) {
        		if(progresses[j]+day*speeds[j]<100) {
        			break;
        		}
        	}
        	
            //개수구하기
        	answer.add(j-i);
        	
            //다음인덱스 시작은 배포한것 다음
        	i=j-1;
        }
        
        return answer.stream().mapToInt(i->i.intValue()).toArray();
    }
}