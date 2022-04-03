import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
        
		int cnt = 0;
		int b = a;
        
		while (true) {
			b = ((b % 10) * 10) + (((b / 10) + (b % 10)) % 10);
			cnt++;
 
			if (a == b) {
				break;
			}
		}
		System.out.println(cnt);
	}
}