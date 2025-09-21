# Problem 1: Count Univalue Subtrees

**Company:** Google  
**Difficulty:** Medium  
**Topic:** Trees, DFS  

---

## 📌 Problem Statement
Given the root of a binary tree, return the number of **univalue subtrees**.  
A **univalue subtree** means all nodes of the subtree have the same value.  

---

## 🔹 Example 1
**Input Tree:**  
Copy code
   5
  / \
 1   5
/ \   \
5 5 5

makefile
Copy code

**Output:**  
4

yaml
Copy code

**Explanation:**  
The 4 univalue subtrees are:  
- The 3 leaf nodes with value `5`  
- The right subtree `(5 -> 5)`  

---

## 🔹 Example 2
**Input Tree:**  
Copy code
   1
  / \
 1   1
/ \
1 1

makefile
Copy code

**Output:**  
5

yaml
Copy code

---

## 🔑 Approaches

### 1. Recursive DFS (Post-order Traversal) ✅
- Traverse tree bottom-up.  
- For each node, check if left and right subtrees are univalue.  
- A node is root of a univalue subtree if:
  - Both children are univalue (or null).  
  - Both children match the current node’s value.  
- Maintain a global counter.  

**Time Complexity:** `O(n)` (each node visited once)  
**Space Complexity:** `O(h)` (recursion stack, `h` = tree height)  

---

## ✅ Java Implementation

See [problem1_CountUnivalSubtrees.java](./problem1_CountUnivalSubtrees.java) for the code.  

---

## 🔗 Practice Links
- [LeetCode – 250. Count Univalue Subtrees](https://leetcode.com/problems/count-univalue-subtrees/)  
- [GeeksforGeeks – Count Univalue Subtrees](https://www.geeksforgeeks.org/count-single-valued-subtr