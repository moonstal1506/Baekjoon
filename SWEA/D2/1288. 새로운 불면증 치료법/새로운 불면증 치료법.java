import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		for (int tc = 1; tc <= size; tc++) {
			int n = sc.nextInt();
			int cnt = 0;
			HashSet<Integer> set = new HashSet<>();
			while (set.size() != 10) {
				cnt++;
				String str = String.valueOf(cnt * n);
				for (int i = 0; i < str.length(); i++) {
					set.add(Integer.valueOf(str.charAt(i)));
				}
			}
			System.out.println("#" + tc + " " + cnt * n);
		}
	}
}