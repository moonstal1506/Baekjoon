class Solution {
    public int[] solution(long n) {
    	char[] c = String.valueOf(n).toCharArray();
    	int[] arr = new int[c.length];
    	int j=0;
    	for(int i=arr.length-1;i>=0;i--) {
    		arr[j++]=c[i]-'0';
    	}
        return arr;
    }
}