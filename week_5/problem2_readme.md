Problem 2 – Swap Even and Odd Bits

Company: Cisco
Difficulty: Medium
Topic: Bit Manipulation

📌 Scenario

Bitwise operations are heavily used in networking, cryptography, and compression algorithms.

Cisco challenges you to perform a bit-level swap:

Given an unsigned 8-bit integer, swap every even-positioned bit with its adjacent odd-positioned bit.

Bits are counted from the right, starting at position 1.

Example:

10101010 → 01010101

11100010 → 11010001

📌 Problem Statement

Write a program that takes an unsigned 8-bit integer and returns the integer after swapping each pair of even and odd bits.

💡 Bonus: Solve it in one line using bitwise operations.

🔹 Input Format

A single integer n (0 ≤ n ≤ 255).

🔹 Output Format

A single integer after swapping even and odd bits.

🔹 Constraints

0 ≤ n ≤ 255

🔹 Sample Input / Output
Sample Input 0
170

Sample Output 0
85

Explanation:

Binary of 170 = 10101010.

Swapping → 01010101 = 85.

Sample Input 1
226

Sample Output 1
209

Explanation:

Binary of 226 = 11100010.

Swapping → 11010001 = 209.

🔑 Approaches

1. Brute Force Bit-by-Bit Swap

Loop through all 8 bits.

Swap each (i, i+1) pair.

Time Complexity: O(8) = O(1)

Space Complexity: O(1)

2. Efficient Bitmasking Approach – One Line ✅

Use bit masks:

Even-position mask = 0xAA = 10101010₂

Odd-position mask = 0x55 = 01010101₂

Formula:

((n & 0xAA) >> 1) | ((n & 0x55) << 1)

(n & 0xAA) >> 1 → shifts even bits right.

(n & 0x55) << 1 → shifts odd bits left.

| merges both.

💻 Java Solution
import java.util.\*;

public class SwapBits {
public static int swapEvenOddBits(int n) {
return ((n & 0xAA) >> 1) | ((n & 0x55) << 1);
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Input: 0 ≤ n ≤ 255
        System.out.println(swapEvenOddBits(n));
    }

}

✅ Key Takeaway:
Using bitmasking and shifting gives a clean, constant-time solution without looping.
