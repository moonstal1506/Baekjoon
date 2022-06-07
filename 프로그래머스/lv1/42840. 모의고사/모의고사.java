import java.util.ArrayList;

class Solution {

    public int[] solution(int[] answers) {
    	int[] a= {1,2,3,4,5};
    	int[] b= {2,1,2,3,2,4,2,5};
    	int[] c= {3,3,1,1,2,2,4,4,5,5};
    	
        int s1=count(answers, a);
        int s2= count(answers, b);
        int s3=count(answers, c);
        int max=Math.max(Math.max(s1, s2), s3);
        
        ArrayList<Integer> arr = new ArrayList<>();
        if(max==s1) arr.add(1);
        if(max==s2) arr.add(2);
        if(max==s3) arr.add(3);
        
        int[] answer = new int[arr.size()];
        for(int i=0;i<arr.size();i++) {
        	answer[i]=arr.get(i);
        }
        return answer;
    }

	private int count(int[] answers, int[] arr) {
		int count =0;
        for(int i=0;i<answers.length;i++) {
        	if(arr[i%arr.length]==answers[i]) {
        		count++;
        	}
        }
        return count;
	}
}