# Problem 1: Minimum Number of Perfect Squares to Sum to N

## Problem Description

You are given a positive integer `n`. Find the smallest number of perfect squares that sum to `n`.

### Example 1

**Input:**  
13  
**Output:**  
2  
**Explanation:** 13 = 9 + 4

### Example 2

**Input:**  
27  
**Output:**  
3  
**Explanation:** 27 = 9 + 9 + 9

---

## Approach

- Use **Dynamic Programming** similar to the Coin Change problem.
- Define `dp[i]` as the minimum number of squares summing to `i`.
- Transition:  
  `dp[i] = min(dp[i - square] + 1)` for each square ≤ `i`.

## Complexity

- **Time:** O(n \* sqrt(n))
- **Space:** O(n)

---

## References

- LeetCode 279: Perfect Squares
- GeeksforGeeks – Minimum number of squares whose sum equals to n
