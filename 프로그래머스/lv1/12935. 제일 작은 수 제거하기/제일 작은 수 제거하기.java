import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
    	if(arr.length<=1) {
    		int[] answer = { -1 };
            return answer;
    	}
    	
    	int[] a = arr.clone();;
    	Arrays.sort(a);
    	int min=a[0];
    	int j=0;
    	int[] answer=new int[arr.length-1];
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]==min) {
    			continue;
    		}else {
    			answer[j++]=arr[i];
    		}
    	}
    	return answer;
    }
}
