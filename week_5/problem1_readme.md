Problem 1 – First Missing Positive Integer

Company: Stripe
Difficulty: Hard
Topic: Arrays, Hashing, In-place Rearrangement

📌 Scenario

Stripe’s payment system uses sequential identifiers. If a number in the sequence goes missing, it can cause serious issues.

Your task is to find the smallest positive integer missing from the array, ensuring:

Time Complexity: O(n)

Space Complexity: O(1) (in-place solution).

📌 Problem Statement

Given an unsorted array of integers arr[], return the first missing positive integer.

The array may contain duplicates and negative numbers.

You are allowed to modify the input array in-place.

🔹 Input Format

First line: Integer N (size of the array).

Second line: N space-separated integers (the array elements).

🔹 Output Format

Print the smallest positive integer that is missing.

🔹 Constraints

1 ≤ N ≤ 10^5

-10^9 ≤ arr[i] ≤ 10^9

🔹 Sample Input / Output
Sample Input 0
4
3 4 -1 1

Sample Output 0
2

Sample Input 1
3
1 2 0

Sample Output 1
3

🔑 Approaches

1. Naïve Approach (Sorting / Hashing)

Sort the array and find the first missing number.

Or insert into a HashSet and check sequentially.

Time: O(n log n)

Space: O(n)

❌ Not acceptable (fails O(1) space requirement).

2. Optimal Approach – Index Placement Trick (In-Place Hashing) ✅

Place each number x at index x-1 (only if 1 ≤ x ≤ N).

After rearrangement, traverse array:

If arr[i] != i+1, return i+1.

If all are correct, return N+1.

Time: O(n)
Space: O(1)

💻 Java Solution
import java.util.\*;

public class FirstMissingPositive {
public static int firstMissingPositive(int[] nums) {
int n = nums.length;

        // Step 1: Rearrange numbers to their correct position
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(firstMissingPositive(arr));
    }

}

✅ Key Takeaway:
This problem tests your ability to rearrange arrays in-place to achieve O(n) time and O(1) space.
