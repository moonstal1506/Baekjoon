import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();
        int rank = 0;
        for (String player : players) {
            map.put(player, rank++);
        }

        for (String calling : callings) {
            int playerRank = map.get(calling);
            players[playerRank] = players[playerRank - 1];
            map.put(players[playerRank], playerRank);

            players[playerRank - 1] = calling;
            map.put(calling, playerRank - 1);
        }

        return players;
    }
}