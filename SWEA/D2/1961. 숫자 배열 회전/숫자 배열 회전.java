import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j]= sc.nextInt();
                }
            }

            int[][] arr1 = rotation(arr);
            int[][] arr2 = rotation(arr1);
            int[][] arr3 = rotation(arr2);

            System.out.println("#" + test_case);
            for (int i = 0; i < arr.length; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < arr.length; j++) {
                    sb.append(arr1[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < arr.length; j++) {
                    sb.append(arr2[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < arr.length; j++) {
                    sb.append(arr3[i][j]);
                }
                System.out.println(sb.toString());
            }

        }
    }

    private static int[][] rotation(int[][] arr) {
        int[][] result = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[arr.length - j - 1][i];
            }
        }
        return result;
    }
}