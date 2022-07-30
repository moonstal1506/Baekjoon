class Solution {
    public long solution(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 1;
        arr[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            arr[i] = arr[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                arr[i] += arr[j] * 2;
            }
            arr[i] %= 1000000007;
        }
        return arr[n];
    }
}