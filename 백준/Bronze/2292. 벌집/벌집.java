import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		int N = sc.nextInt();
		int count = 1;
		int range = 2;	// 최솟값 
 
		if (N == 1) {
			System.out.print(1);
		}
 
		else {
			while (range <= N) {	//2라면 ++ 최솟값부터가 범위증가
				range = range + (6 * count);	
				count++;	
			}
			System.out.print(count);
		}
	}
}