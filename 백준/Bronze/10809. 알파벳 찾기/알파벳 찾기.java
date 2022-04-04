import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}

		String S = sc.nextLine();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			
			if (arr[ch - 'a'] == -1) {
				arr[ch - 'a'] = i;//첫번째로 나타난 위치i
			}
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}
}