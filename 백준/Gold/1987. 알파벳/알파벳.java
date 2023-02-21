import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static char[][] map;
	static boolean[][] isVisited;
	static boolean[] alphabet;
	static int answer = 0;
	static int C;
	static int R;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		isVisited = new boolean[R][C];
		alphabet = new boolean[26];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		dfs(0, 0, 1);
		System.out.println(answer);
	}

	private static void dfs(int x, int y, int cnt) {
		answer = Math.max(answer, cnt);
		alphabet[map[x][y] - 'A'] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 > nx || 0 > ny || R <= nx || C <= ny) continue;
			if (alphabet[map[nx][ny] - 'A']) continue;
			
			dfs(nx, ny, cnt + 1);
			alphabet[map[nx][ny] - 'A'] = false;
		}

	}
}