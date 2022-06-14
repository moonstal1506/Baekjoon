import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s: scoville) {
        	q.add(s);
        }
        while(q.peek()<K) {
        	if(q.size()==1) {
        		return -1;
        	}
        	q.add(q.poll()+q.poll()*2);
        	answer++;
        }
        
        return answer;
    }
}