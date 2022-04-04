import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[26];
		String s = sc.next();
		String up = s.toUpperCase();
		for (int i = 0; i < up.length(); i++) {
			arr[up.charAt(i) - 'A']++;
		}

		int max = -1;
		char ch = '?';

		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				ch = (char) (i + 'A'); 
			} else if (arr[i] == max) {
				ch = '?';
			}
		}

		System.out.print(ch);
	}

}