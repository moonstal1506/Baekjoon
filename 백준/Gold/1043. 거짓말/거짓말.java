import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<Integer> truth;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 진실을 알고 있는 사람
        st = new StringTokenizer(br.readLine());
        int trueNum = Integer.parseInt(st.nextToken());
        if (trueNum == 0) {
            System.out.println(m);
            return;
        }
        truth = new HashSet<>();
        for (int i = 0; i < trueNum; i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        }

        // 초기화
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        List<List<Integer>> party = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            party.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int attNum = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            party.get(i).add(first);
            for (int j = 1; j < attNum; j++) {
                int second = Integer.parseInt(st.nextToken());
                union(first, second);
                party.get(i).add(second);
            }
        }

        // 진실을 아는 사람과 연결된 모든 사람을 truth에 추가
        for (int person : new ArrayList<>(truth)) {
            truth.add(find(person));
        }

        // 파티가 가능한지 확인
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (possible(party.get(i))) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean possible(List<Integer> attendees) {
        for (int att : attendees) {
            if (truth.contains(find(att))) {
                return false;
            }
        }
        return true;
    }

    private static void union(int first, int second) {
        int pf = find(first);
        int ps = find(second);

        if (pf != ps) {
            parents[ps] = pf;
        }
    }

    private static int find(int num) {
        if (parents[num] == num) {
            return num;
        }
        return parents[num] = find(parents[num]); // 경로 압축
    }
}