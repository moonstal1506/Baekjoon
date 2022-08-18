import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();

        int idx=0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, idx);
                idx++;
            }
        }
        for (int key : arr) {
            sb.append(map.get(key)).append(" ");
        }
        System.out.println(sb);
    }
}