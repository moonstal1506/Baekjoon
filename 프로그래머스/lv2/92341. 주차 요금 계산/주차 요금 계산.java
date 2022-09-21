import java.util.*;

class Solution {

    HashMap<String, String> inMap = new HashMap<>();
    HashMap<String, Integer> timeMap = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {

        //레코드 돌아 공백으로 자르기
        for (String record : records) {
            String time = record.split(" ")[0];
            String car = record.split(" ")[1];

            //처음 온 자동차라면 이름으로 맵에 시간 넣어줘
            if (!inMap.containsKey(car)) {
                inMap.put(car, time);
            } else {
                //처음 아니면 시간 꺼내서 아웃시간이랑 계산하고 타임맵에 넣어줌
                timeMap.put(car, timeMap.getOrDefault(car, 0) + calc(inMap.remove(car), time));
            }
        }

        //아직 나오지 않은 차들 11시59분으로 계산해서 타임맵
        for (String car : inMap.keySet()) {
            timeMap.put(car, timeMap.getOrDefault(car, 0) + calc(inMap.get(car), "23:59"));
        }

        //타임맵 키로 정렬하고 돌면서 요금 계산하기
        //기본시간 안넘으면 기본요금
        List<Map.Entry<String, Integer>> list = new ArrayList(timeMap.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
        });

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Integer total = list.get(i).getValue();
            System.out.println("total = " + total);
            if (total > fees[0]) {
                answer[i] = (int) (fees[1] + Math.ceil((total - fees[0]) / (double)fees[2]) * fees[3]);
            } else {
                answer[i] = fees[1];
            }
        }
        return answer;
    }

    private int calc(String in, String out) {
        return timeToMinute(out) - timeToMinute(in);
    }

    private int timeToMinute(String time) {
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] solution1 = solution.solution(
//                new int[]{1, 461, 1, 10},
//                new String[]{"00:00 1234 IN"});
//        for (int arg : solution1) {
//            System.out.println("arg = " + arg);
//        }
//    }
}