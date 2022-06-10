class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // 이진수바꾸기, 포맷 , 이진수 문자로
        for(int i=0;i<n;i++) {
        	String str = Integer.toBinaryString(arr1[i]|arr2[i]);
        	str=str.format("%"+n+"s", str);
        	str=str.replaceAll("0", " ");
        	str=str.replaceAll("1", "#");
        	answer[i]=str;
        }
        
        return answer;
    }
}