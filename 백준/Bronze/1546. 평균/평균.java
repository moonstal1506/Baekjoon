import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i]=sc.nextInt();
        }
    
        Arrays.sort(arr);
        double sum = 0;
        for(int i=0;i<n;i++) {
        	sum+=((arr[i] / (double)arr[arr.length-1]) * 100);
        }
        System.out.print(sum / arr.length);
	}
}