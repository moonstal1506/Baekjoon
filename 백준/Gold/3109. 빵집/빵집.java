import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static char[][] map;
	static int R;
	static int C;
	static int answer;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			flag=false;
			map[i][0] = 'o';
			dfs(i, 0, 1);
		}

		System.out.println(answer);
	}

	private static void dfs(int x, int y, int cnt) {

		if (cnt+1 == C) {
			answer++;
			flag=true;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 > nx || 0 > ny || R <= nx || C <= ny) {
				continue;
			}
				
			if (map[nx][ny] == 'x' || map[nx][ny] == 'o') {
				continue;
			}
			
			map[nx][ny] = 'o';
			dfs(nx, ny, cnt + 1);
			if(flag) {
				return;
			}
		}
	}
}