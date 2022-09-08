class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (true) {
            int len = s.length();
            String tmp = "";
            answer[0]++;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '1') {
                    tmp += '1';
                }else {
                    answer[1]++;
                }
            }
            if (tmp.equals("1")) {
                break;
            }else {
                s = Integer.toBinaryString(tmp.length());
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution("01110");
        System.out.println("solution1[0] solution1[1] = " + solution1[0]+" "+solution1[1]);
    }
}