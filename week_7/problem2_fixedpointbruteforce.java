package week_7;

import java.util.*;

public class problem2_fixedpointbruteforce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == i) {
                System.out.println(i);
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("False");
    }
}
