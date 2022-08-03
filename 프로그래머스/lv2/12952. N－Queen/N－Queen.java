class Solution {

    //배열, n, 답
    int[] arr;
    int n;
    int answer = 0;

    public int solution(int n) {
        //배열생성, dfs호출
        arr = new int[n];
        this.n = n;
        dfs(0);
        return answer;
    }

    //체스 다 채웠을 때 카운트
    //배열의 열기준 행돌림 가능하면 dfs
    private void dfs(int idx) {
        if (idx == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[idx] = i;
            if (possible(idx)) {
                dfs(idx+1);
            }
        }
    }

    //안되는 경우: 행일치, 대각선
    //열돌려 행확인
    //대각선 기울기 1,-1
    private boolean possible(int idx) {
        for (int i = 0; i < idx; i++) {
            if (arr[idx] == arr[i]) return false;
            if (Math.abs(arr[idx] - arr[i]) == Math.abs(idx - i)) return false;
        }
        return true;
    }
}