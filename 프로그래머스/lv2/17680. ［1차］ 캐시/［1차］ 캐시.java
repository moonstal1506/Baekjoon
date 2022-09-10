import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0){
            return cities.length * 5;

        }
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            //히트
            if(q.contains(city)){
                answer++;
                q.remove(city);
                q.add(city);
            }
            //미스
            else {
                answer += 5;
                if(q.size()==cacheSize) {
                    q.poll();
                    q.add(city);
                }else {
                    //처음
                    q.add(city);
                }
            }
        }
        return answer;
    }
}