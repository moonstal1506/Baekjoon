class Solution {
    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcd(w, h));
    }

    private long gcd(int w, int h) {
        if (w % h == 0) {
            return h;
        }
        return gcd(h, w % h);
    }
}