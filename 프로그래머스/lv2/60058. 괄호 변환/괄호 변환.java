import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }
        if (isBalance(p)) {
            return p;
        }
        return dfs(p);

    }

    private boolean isBalance(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private String dfs(String w) {
        if (w.length() == 0) {
            return "";
        }
        String u = "";
        String v = "";
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c == '(')
                cnt1++;
            else
                cnt2++;
            if ((cnt1 != 0 && cnt2 != 0) && cnt1 == cnt2) {
                u = w.substring(0, i + 1);
                if (i != w.length() - 1) {
                    v = w.substring(i + 1, w.length());
                }
                break;
            }
        }
        if (!isBalance(u)) {
            String tmp = "(" + dfs(v);
            tmp += ")";
            u = u.substring(1, u.length() - 1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            tmp += u;
            return tmp;
        } else {
            return u + dfs(v);
        }
    }
}