import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--) {
        	sb.append(c[i]);
        }
        return sb.toString();
    }
}