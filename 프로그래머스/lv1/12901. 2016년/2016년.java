
class Solution {
    public String solution(int a, int b) {
    	int[] day= {31,29,31,30,31,30,31,31,30,31,30,31};
    	String[] week= {"FRI","SAT","SUN","MON","TUE","WED","THU"};
    	int sum=0;
    	for(int i=0;i<a-1;i++) {
    		sum+=day[i];
    	}
    	sum+=b-1;
    	return week[sum%7];
    	
    }
}
