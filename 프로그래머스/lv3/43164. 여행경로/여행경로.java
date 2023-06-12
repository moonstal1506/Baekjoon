import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    List<String> routes;
    String[][] tickets;
    boolean[] isVisited;

    public String[] solution(String[][] tickets) {
        routes = new ArrayList<>();
        this.tickets = tickets;
        isVisited = new boolean[tickets.length];
        dfs("ICN", "ICN", 0);
        Collections.sort(routes);
        return routes.get(0).split(" ");
    }

    private void dfs(String from, String route, int cnt) {
        if (cnt == tickets.length) {
            routes.add(route);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (isVisited[i] || !tickets[i][0].equals(from)) {
                continue;
            }
            isVisited[i] = true;
            dfs(tickets[i][1], route + " " + tickets[i][1], cnt + 1);
            isVisited[i] = false;
        }
    }
}