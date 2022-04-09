import java.util.Scanner;

//클래스 변수 불린 false로 초기화됨
//n+1배열생성
//소수 구하기 불린
//0과1,배수는 true로 바꿔줌
//루트값까지만 구해
//합과 최솟값
//첫소수가 최솟값
//소수가 없다면 있따면
public class Main {

	public static boolean prime[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		
		prime= new boolean[n+1];
		getPrime();
		
		int sum=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=m;i<n+1;i++) {
			if(prime[i]!=true) {
				sum+=i;
				if(min==Integer.MAX_VALUE) {
					min=i;
				}
			}
		}
		
		if(sum==0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
		

	}

	private static void getPrime() {
		prime[0]=true;
		prime[1]=true;
		
		for(int i=2;i<Math.sqrt(prime.length);i++) {
			for(int j=i*i;j<prime.length;j+=i) {
				prime[j]=true;
			}
		}
	}
}