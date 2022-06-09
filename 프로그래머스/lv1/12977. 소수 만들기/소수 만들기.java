class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum=0;
        for(int i=0;i<nums.length;i++) {
        	for(int j=i+1;j<nums.length;j++) {
        		for(int k=j+1;k<nums.length;k++) {
        			sum=nums[i]+nums[j]+nums[k];
        			if(sum==2) {
        				answer++;
        			}
        			Boolean b = true;
        			for(int t=2;t<sum;t++) {
        				if(sum%t==0) {
        					b=false;
        					break;
        				}
        			}
        			if(b) answer++;
        		}
        	}
        }
        return answer;
    }
}