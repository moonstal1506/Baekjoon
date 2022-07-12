import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = 9;
        int[] p = new int[9];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
            sum += p[i];
        }

        Arrays.sort(p);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(sum-p[i]-p[j]==100){
                    for(int k=0;k<n;k++){
                        if(k==i||k==j) continue;
                        System.out.println(p[k]);
                    }
                    System.exit(0);
                }
            }
        }

    }
}