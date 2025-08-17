package week_1;

import java.util.*;

public class problem6_GCDofNnumbers {

    // Euclidean Algorithm for gcd of two numbers
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // GCD of N numbers
    public static int findGCD(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);

            // early stop: if gcd becomes 1, no smaller gcd is possible
            if (result == 1)
                return 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of integers
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findGCD(arr);
        System.out.println(result);

        sc.close();
    }
}
