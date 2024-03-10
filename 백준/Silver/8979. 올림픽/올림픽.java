import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int n = Integer.parseInt(st.nextToken());
        int nation = Integer.parseInt(st.nextToken());
        List<Nation> nations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String medal = br.readLine();
            st = new StringTokenizer(medal, " ");
            int curNation = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            nations.add(new Nation(curNation, gold, silver, bronze));
        }

        Collections.sort(nations);
        findRank(nations, nation);
    }

    private static void findRank(List<Nation> nations, int nation) {
        int rank = 1;
        if (nation == nations.get(0).num) {
            System.out.println(rank);
            return;
        }

        int cnt = 1;
        for (int i = 1; i < nations.size(); i++) {
            if (nations.get(i).gold == nations.get(i - 1).gold && nations.get(i).silver == nations.get(i - 1).silver && nations.get(i).bronze == nations.get(i - 1).bronze) {
                cnt++;
            } else {
                rank += cnt;
                cnt = 1;
            }
            if (nations.get(i).num == nation) {
                System.out.println(rank);
                return;
            }
        }
    }

}

class Nation implements Comparable<Nation> {
    int num, gold, silver, bronze;

    public Nation(int num, int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Nation o) {
        if (this.gold != o.gold) {
            return o.gold - this.gold;
        }

        if (this.silver != o.silver) {
            return o.silver - this.silver;
        }

        return o.bronze - this.bronze;
    }
}