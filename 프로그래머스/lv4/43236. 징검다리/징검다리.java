import java.util.Arrays;

class Solution {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int start = 0;
        int end = distance;
        int[] position = new int[rocks.length + 1];
        
        for (int i = 0; i < position.length - 1; i++) {
            position[i] = rocks[i];
        }
        position[position.length - 1] = distance;
        Arrays.sort(position);
        while (start <= end) {
            //mid의 최대값을 구해야해
            int mid = (start + end) / 2;
            if (countRemovedRock(mid, position) <= n) {
                //지운돌이 작거나 같으면 가능 답세팅하고 왼쪽 올려
                answer = mid;
                start = mid + 1;
            } else {
                //불가능 오른쪽 내려
                end = mid - 1;
            }
        }
        return answer;
    }

    private int countRemovedRock(long mid, int[] position) {
        long tmp = 0;
        int cnt = 0;
        //반복문 돌면서 돌 지우기
        for (int i = 0; i < position.length; i++) {
            //최소거리가 mid니까 그것보다 작은 애들은 지워
            if (position[i] - tmp < mid) {
                cnt++;
            } else {
                tmp = position[i];
            }
        }
        return cnt;
    }
}