import java.util.*;


public class Main {

    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //2차원배열
        arr = new char[n][n];

        //재귀(x,y,사이즈, 공백여부)
        dfs(0, 0, n, false);

        //찍기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int n, boolean empty) {
        //공백 참이면 사이즈 만큼 공백찍기,
        if (empty) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        //사이즈 1이면 별찍기
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        //시작위치에서 +n만큼 돌리고 3으로 나눈만큼 증가시켜 cnt5일때 공백
        int cnt = 0;
        int size = n / 3;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                cnt++;
                if (cnt == 5) {
                    dfs(i,j,size,true);
                }else {
                    dfs(i,j,size,false);
                }
            }
        }

    }
}
