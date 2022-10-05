class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;

        for(int i = 0; i<m.length();i++){
            m = m.replace("A#","a");
            m = m.replace("C#","c");
            m = m.replace("D#","d");
            m = m.replace("F#","f");
            m = m.replace("G#","g");
            m = m.replace("E#","e");
        }

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            split[3] = split[3].replace("A#","a");
            split[3] = split[3].replace("C#","c");
            split[3] = split[3].replace("D#","d");
            split[3] = split[3].replace("F#","f");
            split[3] = split[3].replace("G#","g");
            split[3] = split[3].replace("E#","e");
            
            int min = toMin(split[1]) - toMin(split[0]);
            String tmp = "";
            for (int i = 0; i < min; i++) {
                tmp += split[3].charAt(i % split[3].length());
            }
            if (tmp.toString().contains(m)) {
                if (max < tmp.length()) {
                    max = tmp.length();
                    answer = split[2];
                }
            }
        }
        return answer;
    }

    private int toMin(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return hour * 60 + min;
    }
}