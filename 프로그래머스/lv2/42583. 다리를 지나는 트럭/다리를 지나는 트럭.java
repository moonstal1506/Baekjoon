import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum=0;
        Queue<Integer> q = new LinkedList<Integer>();
        
        //무게돌려
        for(int truck:truck_weights) {
        	//반복
        	while(true) {
        		 //큐비어있으면 넣고 합계더하기 시간++ 멈추기
        		if(q.isEmpty()) {
        			q.add(truck);
        			sum+=truck;
        			answer++;
        			break;
        	    //큐가 다리길이만큼이면 합계에서 뻬줌
        		}else if(q.size()==bridge_length) {
        			sum-=q.poll();
        			
        		}else {
        			//더한 무게합이 다리무게 보다 크면 0넣어주고 시간++
        			if(sum+truck>weight) {
        				q.add(0);
        				answer++;
        			//아니라면 큐에 넣고 합계더하고 시간++ 멈추기
        			}else {
        				q.add(truck);
        				sum+=truck;
        				answer++;
        				break;
        			}
        		}
        	}
        }
        //마지막 다리 길이 더해주기
        return answer+bridge_length;
    }
}