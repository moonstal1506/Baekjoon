class Solution {
    public int solution(int[] money) {
        int[] first = new int[money.length];
        int[] second = new int[money.length];
        first[0] = first[1] = money[0];
        second[1] = money[1];
        
        for (int i = 2; i < money.length; i++) {
            first[i] = Math.max(first[i - 1], first[i - 2] + money[i]);
            second[i] = Math.max(second[i - 1], second[i - 2] + money[i]);
        }
        
        return Math.max(first[money.length - 2], second[money.length - 1]);
    }
}