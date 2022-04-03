import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n= sc.nextInt();
		int[] arr = new int[t];
		
		for(int i=0; i<t;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int a: arr) {
			if(a<n) {
				System.out.print(a+" ");
			}
		}
	}
}