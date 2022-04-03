import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		
		for (int i = 0; i < n; i++) {
			int stu= sc.nextInt();
			int[] arr= new int[stu];
			
			double sum = 0;
			
			for(int j = 0 ; j < stu ; j++) {
				arr[j] = sc.nextInt();	// 성적 입력 
				sum += arr[j];	// 성적 누적 합 
			}
			
			double mean = (sum / stu) ;
			double count = 0;
			
			for(int j = 0 ; j < stu ; j++) {
				if(arr[j] > mean) {
					count++;
				}
			}
			System.out.printf("%.3f%%\n",(count/stu)*100);
		}
		
	}

}