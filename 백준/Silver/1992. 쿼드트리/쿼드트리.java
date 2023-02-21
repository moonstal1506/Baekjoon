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
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int cnt = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		cut(0,0,N);
		System.out.println(sb);
	}

	static void cut(int r, int c, int size) {

		int white = 0;
		int black = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] == 0) {
					white++;
				} else {
					black++;
				}
			}
		}

		if (white == 0) {
			sb.append("1");
		} else if (black == 0) {
			sb.append("0");
		} else {
			sb.append("(");
			int half = size / 2;
			cut(r, c, half);
			cut(r, c + half, half);
			cut(r + half, c, half);
			cut(r + half, c + half, half);
			sb.append(")");
		}

	}
}