import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
        	if(!list.contains(nums[i])) {
        		list.add(nums[i]);
        	}
        }
        return list.size()>=nums.length/2? nums.length/2:list.size();
    }
}