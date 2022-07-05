import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int cnt=1;
            int x=1;
            while(x%num!=0){
                x=(x*10+1)%num;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
