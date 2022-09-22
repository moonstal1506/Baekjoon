class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = "";
        while (n > 0) {
            str = n % k + str;
            n /= k;
        }

        String[] split = str.split("0");
        for (String s : split) {
            if (s.equals("")) continue;
            if (isPrime(Long.parseLong(s))) answer++;
        }
        return answer;
    }

    private boolean isPrime(long s) {
        if (s == 1) return false;
        for (int i = 2; i <= Math.sqrt(s); i++) {
            if (s % i == 0) return false;
        }
        return true;
    }

}