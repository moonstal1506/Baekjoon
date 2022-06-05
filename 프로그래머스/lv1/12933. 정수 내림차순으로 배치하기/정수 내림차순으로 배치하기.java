
import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String string = new StringBuilder(new String(charArray)).reverse().toString();
		return Long.parseLong(string);
    }
}
