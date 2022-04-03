import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
    	int max = -1;
		double sum = 0.0;
		
		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			
			if(value > max) {
				max = value;
			}
			
			sum += value;
		}
		System.out.println(((sum / max) * 100.0) / n);
	}
}