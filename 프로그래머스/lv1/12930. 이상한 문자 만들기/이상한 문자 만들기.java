class Solution {
    public String solution(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int j=0;
        for(int i=0;i<c.length;i++) {
        	if(c[i]==' ') {
        		j=0;
        		sb.append(c[i]);
        		continue;
        	}
        	if(j%2==0) {
        		sb.append(Character.toUpperCase(c[i]));
        	}else {
        		sb.append(Character.toLowerCase(c[i]));
        	}
        	j++;
        }
        return sb.toString();
    }
}