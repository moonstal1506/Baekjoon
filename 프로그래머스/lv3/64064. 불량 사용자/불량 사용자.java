import java.util.HashSet;
import java.util.Set;

class Solution {

    String[] user_id;
    String[] banned_id;
    Set<HashSet<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id=user_id;
        this.banned_id=banned_id;
        dfs(new HashSet<String>(), 0);
        return result.size();
    }

    private void dfs(HashSet<String> set, int depth) {
        if (depth == banned_id.length) {
            result.add(set);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (set.contains(user_id[i])) {
                continue;
            }
            if(isSame(user_id[i],banned_id[depth])){
                set.add(user_id[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(user_id[i]);
            }
        }
    }

    private boolean isSame(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            if(bannedId.charAt(i)!='*'&&userId.charAt(i)!=bannedId.charAt(i)){
                return false;
            }
        }

        return true;
    }
}