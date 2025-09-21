# Problem 4: Longest Increasing Subsequence (LIS)

**Company:** Microsoft  
**Difficulty:** Medium  
**Topic:** Dynamic Programming

---

## 📌 Problem Statement

Given an array of numbers, find the length of the **Longest Increasing Subsequence (LIS)**.  
The subsequence does not need to be contiguous, but the order must be maintained.

---

## 🔹 Example

**Input:**  
[0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]

makefile
Copy code

**Output:**  
6

yaml
Copy code

**Explanation:**  
The LIS is `[0, 2, 6, 9, 11, 15]` of length `6`.

---

## 🔑 Approaches

### 1. Recursive + Memoization (Top-Down DP)

- Try including or excluding each element.
- Memoize results to avoid recomputation.
- **Time Complexity:** `O(n^2)`
- **Space Complexity:** `O(n^2)` (due to recursion + memo).

---

### 2. Bottom-Up DP (Classic DP)

- Use an array `dp[i]` = length of LIS ending at index `i`.
- Transition:  
  dp[i] = 1 + max(dp[j]) for all j < i where arr[j] < arr[i]

markdown
Copy code

- Answer = `max(dp[i])` over all i.
- **Time Complexity:** `O(n^2)`
- **Space Complexity:** `O(n)`

---

### 3. Optimized Approach with Binary Search (Patience Sorting Method) ✅

- Maintain a temporary array (`temp`).
- For each number:
- If greater than the largest element in `temp`, append it.
- Else, replace the smallest element ≥ current number.
- Length of `temp` = LIS length.

- **Time Complexity:** `O(n log n)`
- **Space Complexity:** `O(n)`

---

## ✅ Java Implementation

See [problem4_LongestIncreasingSubsequence.java](./problem4_LongestIncreasingSubsequence.java) for the code.

---

## 🔗 Practice Links

- [LeetCode – 300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
- [GeeksforGeeks – Longest Increasing Subsequence](https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/)
