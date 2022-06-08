import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        // 정렬
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        //맞은 개수, 0개수
        int cnt=0;
        int cnt0=0;
        for(int lotto:lottos) {
        	if(Arrays.binarySearch(win_nums, lotto)>=0) {
        		cnt++;
        	}
        	if(lotto==0) {
        		cnt0++;
        	}
        }
        
        //최고 최저
        int[] answer = new int[2];
        answer[0]= Math.min(7-cnt-cnt0, 6);
        answer[1]= Math.min(7-cnt, 6);
        
        return answer;
    }
}