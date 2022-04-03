import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int s = a * b * c;
		String str = Integer.toString(s);

		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			int cnt=0;
			for(int j=0;j<str.length();j++) {

				if(i==(str.charAt(j)-'0')) {
					cnt++;
				}
				
			}
			arr[i]=cnt;
		}
		
		for(int sum:arr) {
			System.out.println(sum);
		}
	}
}