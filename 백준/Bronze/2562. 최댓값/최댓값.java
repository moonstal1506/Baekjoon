import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
		}
		
		int max=0;
		int cnt=0;
		int answer=0;
		for(int a : arr) {
			cnt++;
			if(a>max) {
				max=a;
				answer=cnt;
			}
		}
		System.out.println(max);
		System.out.println(answer);
	}
}