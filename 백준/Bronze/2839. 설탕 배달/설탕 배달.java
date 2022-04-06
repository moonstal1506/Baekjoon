import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num=0;
		while(true) {
			if(n%5==0) {
				num+=n/5;
				System.out.println(num);
				break;
			}
			if(n<0){
				System.out.println("-1");
				break;
			}
			n-=3;
			num++;
		}
	}
}