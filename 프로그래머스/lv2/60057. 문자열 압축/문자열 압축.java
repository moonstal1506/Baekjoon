class Solution {
    public int solution(String s) {
        //문자길이 초기화
        int answer = s.length();

        //압축최대크기 문자길이의 반, 압축1부터 시작, 문자추출, 결과문자sb
        for (int i = 1; i <= s.length() / 2; i++) {
            String str = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            int cnt = 1;

            //다음문자 압축크기만큼 증가하면서 추출, 숫자넘어가면 길이만큼
            for (int j = i; j <= s.length(); j += i) {
                String cur = s.substring(j, Math.min(j + i, s.length()));

                //문자열 같을때 카운트,
                if (str.equals(cur)) {
                    cnt++;
                }else {
                    //다를때 압축된거 있음?숫자 공통-문자추가,
                    if(cnt!=1) sb.append(cnt);
                    sb.append(str);
                    //새문자&카운트1초기화
                    str = cur;
                    cnt = 1;
                }
            }
            //마지막 문자 추가 후 길이
            sb.append(str);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}