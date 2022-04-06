import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0; i<t;i++) {
			int h=sc.nextInt();
			int w=sc.nextInt();
			int n=sc.nextInt();
			int num;
			int floor;
			if( n % h == 0 ) {
				floor= h;
				num=n/h;
			}else {
				floor=n%h;
				num=n/h+1;
			}
			System.out.println(floor*100+num);
		}
		
	}
}