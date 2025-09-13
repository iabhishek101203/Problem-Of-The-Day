package week_5;

import java.util.*;

public class problem2_qSwapBits {
    public static int swapEvenOddBits(int n) {
        return ((n & 0xAA) >> 1) | ((n & 0x55) << 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Input: 0 ≤ n ≤ 255
        System.out.println(swapEvenOddBits(n));
    }
}
