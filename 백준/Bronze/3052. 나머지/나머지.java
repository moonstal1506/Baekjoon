import java.util.Scanner;

class Main {
	public static void main(String[] args) {
	
		
        boolean[] arr = new boolean[42];
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0 ; i < 10 ; i++) {
            arr[sc.nextInt() % 42] = true;
        }
        
        int count = 0;
        for(boolean value : arr) {
            if(value){    
                count++;
            }
        }
        System.out.println(count);
    
	}
}