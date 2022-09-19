import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

class Solution {
    public int solution(String str1, String str2) {
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < s1.length() - 1; i++) {
            char a = s1.charAt(i);
            char b = s1.charAt(i+1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                list1.add(a + "" + b);
            }
        }

        for (int i = 0; i < s2.length() - 1; i++) {
            char a = s2.charAt(i);
            char b = s2.charAt(i+1);
            if (Character.isLetter(a) && Character.isLetter(b)){
            list2.add(a+""+b);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1.size());
        System.out.println(list2.size());

        List<String> k = new ArrayList<>();
        List<String> h = new ArrayList<>();
        for(String s : list1) {
            if(list2.remove(s)) {
                k.add(s);
            }
            h.add(s);
        }
        for (String b : list2) {
            h.add(b);
        }

        double sum = h.size();
        double kyo = k.size();

        if(sum==0){
            return 65536;
        }else {
            return (int)(kyo/sum*65536);
        }
    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int solution1 = solution.solution("FRANCE", "french");
//        System.out.println(solution1);
//    }
}