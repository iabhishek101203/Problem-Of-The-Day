# Problem 3: Bitwise AND of a Range

**Company:** Yahoo  
**Difficulty:** Medium  
**Topic:** Bit Manipulation

---

## 📌 Problem Statement

Write a function that returns the bitwise AND of all integers between `M` and `N` (inclusive).

Formally:  
result = M & (M+1) & (M+2) & ... & N

yaml
Copy code

---

## 🔹 Example 1

**Input:**  
M = 5, N = 7

makefile
Copy code

**Output:**  
4

makefile
Copy code

**Explanation:**  
5 = 101
6 = 110
7 = 111
5 & 6 & 7 = 100 = 4

yaml
Copy code

---

## 🔹 Example 2

**Input:**  
M = 0, N = 1

makefile
Copy code

**Output:**  
0

makefile
Copy code

**Explanation:**  
0 = 0
1 = 1
0 & 1 = 0

yaml
Copy code

---

## 🔑 Approaches

### 1. Naive Approach

- Iterate from `M` to `N`.
- Keep applying `&` operator.
- **Time Complexity:** `O(N - M)` → inefficient for large ranges.

---

### 2. Optimized Approach (Bitwise Trick) ✅

- The result is the **common prefix** of `M` and `N` in binary.
- Keep shifting both `M` and `N` to the right until they become equal.
- Count the number of shifts and shift back to the left.

**Time Complexity:** `O(log N)`  
**Space Complexity:** `O(1)`

---

## ✅ Java Implementation

See [problem3_BitwiseAndRange.java](./problem3_BitwiseAndRange.java) for the code.

---

## 🔗 Practice Links

- [LeetCode – 201. Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/)
- [GeeksforGeeks – Bitwise AND of a range](https://www.geeksforgeeks.org/bitwise-and-or-of-a-range/)
