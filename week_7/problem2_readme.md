# Problem of the Week – Fixed Point in a Sorted Array

**🏢 Company:** Apple  
**🎯 Difficulty:** Medium  
**📌 Topics:** Binary Search, Arrays

---

## 📖 Problem Statement

In algorithmic problem solving, a **fixed point** in an array is an index `i` such that:

arr[i] == i

yaml
Copy code

Apple engineers use this property in certain optimization checks.  
You are given a **sorted array of distinct integers**, and you need to find if such a fixed point exists.

Return the fixed point if it exists, otherwise return `False`.

---

## 🖊 Input Format

- First line: integer `N` – size of the array.
- Second line: `N` space-separated integers (sorted, distinct).

## 🖊 Output Format

- Print the fixed point if it exists.
- Otherwise print `False`.

---

## ⚡ Constraints

- `1 ≤ N ≤ 10^5`
- Array elements can be **negative, zero, or positive**.
- Elements are **distinct and sorted** in increasing order.

---

## 💡 Examples

### Example 1

**Input**  
4
-6 0 2 40
**Output**  
2

**Explanation**  
At index `2`, we have `arr[2] = 2`. Hence, the fixed point is `2`.

---

### Example 2

**Input**  
4
1 5 7 8

**Output**  
False

**Explanation**  
No index `i` satisfies `arr[i] == i`.

---

## 🔑 Approaches

### 1. Brute Force (O(N))

- Iterate through the array.
- Check if `arr[i] == i`.
- Return the first such index or `False`.

### 2. Binary Search (O(log N)) ✅

- Since array is sorted and distinct:
  - If `arr[mid] == mid`, return `mid`.
  - If `arr[mid] > mid`, search **left half**.
  - If `arr[mid] < mid`, search **right half**.

**Time Complexity:** `O(log N)`  
**Space Complexity:** `O(1)`

---

## 🔗 References

- [GeeksforGeeks – Fixed Point in an array](https://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/)
- [LeetCode Discussions – Fixed Point Problem](https://leetcode.com/discuss/interview-question/algorithms/124676/fixed-point-in-an-array)
