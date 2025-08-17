# Problem 3 – Equal Sum Partition (Facebook)

### 📌 Problem Statement

Given an array of non-negative integers, determine if it can be partitioned into two subsets such that the sum of elements in both subsets is equal.

---

### ✅ Examples

**Example 1:**
Input: [15, 5, 20, 10, 35, 15, 10]
Output: true

Explanation:

- Subset 1 → [15, 5, 10, 15, 10] = 55
- Subset 2 → [20, 35] = 55

**Example 2:**
Input: [15, 5, 20, 10, 35]
Output: false

Explanation:

- Total sum = 85 → cannot be split equally.

---

### 📌 Approach

1. Compute total sum. If it is odd → return false.
2. Set target = sum/2.
3. Use Dynamic Programming to check if we can form a subset with sum = target.
   - Initialize `dp[0] = true`.
   - For each number, update dp array backwards.
   - Finally, return `dp[target]`.

---

### 📌 Java Solution

```java
public static boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num;
    if (sum % 2 != 0) return false;
    int target = sum / 2;

    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    for (int num : nums) {
        for (int j = target; j >= num; j--) {
            dp[j] = dp[j] || dp[j - num];
        }
    }
    return dp[target];
}
```

📌 Complexity Analysis

Time Complexity: O(N × target) where target = sum/2

Space Complexity: O(target)

🚀 Extensions

Recover the actual subsets (not just return true/false).

Solve using recursion + memoization (top-down).

✨ Practice Links

Leetcode – Partition Equal Subset Sum (#416)

GeeksforGeeks – Partition Problem

---

✅ This gives you:

- One file for **Problem-3 Java solution**
- README updated with explanation + code + complexity
