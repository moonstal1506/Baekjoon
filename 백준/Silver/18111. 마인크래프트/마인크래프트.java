import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int minTime = Integer.MAX_VALUE;
		int height = Integer.MIN_VALUE;

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				min = Math.min(min, n);
				max = Math.max(max, n);
				arr[i][j] = n;

			}
		}

		for (int n = min; n <= max; n++) {
			if (n > 256) {
				break;
			}
			int cnt = B;
			int time = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (n > arr[i][j]) {
						time += n - arr[i][j];
						cnt -= n - arr[i][j];
						continue;
					}

					if (n < arr[i][j]) {
						time += (arr[i][j] - n)* 2;
						cnt += arr[i][j] - n;
					}
				}
			}
			if (cnt < 0) {
				break;
			}
			if (minTime >= time) {
				minTime = time;
				height = Math.max(n, height);
			}
		}

		System.out.println(minTime + " " + height);
	}
}