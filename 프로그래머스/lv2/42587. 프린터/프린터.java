import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        //어레이리스트에 대기목록 담기
        List<Job> list = new ArrayList<>();
        for(int i=0;i<priorities.length;i++) {
        	list.add(new Job(priorities[i],i));
        }
        
        //비어있지 않을 때까지 돌고 앞에꺼 꺼내서 가장 큰지 확인 작으면 다시 뒤로 크면 ++ 찾았으면 멈춰
        while(!list.isEmpty()) {
        	Job job = list.remove(0);
        	if(list.stream().anyMatch(i->i.priority>job.priority)) {
        		list.add(job);
        	}else {
        		answer++;
        		if(job.location==location) {
        			break;
        		}
        	}
        }
        return answer;
    }
    
    static class Job{
    	int priority;
    	int location;
    	
		public Job(int priority, int location) {
			this.priority = priority;
			this.location = location;
		}
    }
}