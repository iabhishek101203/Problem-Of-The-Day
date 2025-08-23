# Problem 3: Maximum Path Sum Between Any Two Nodes in a Binary Tree

**Company:** Google  
**Topic:** Binary Trees, Dynamic Programming

---

## Problem Statement

Given a binary tree where each node contains an integer value, find the **maximum path sum** between any two nodes.

- The path must go through at least one node.
- The path does not need to pass through the root.
- A path is a sequence of nodes connected by edges, and each node can appear only once.

---

## Example

**Input Tree:**
markdown
Copy
Edit
-10
/ \
 9 20
/ \
 15 7
makefile
Copy
Edit

**Output:**
42

yaml
Copy
Edit
**Explanation:** The maximum path is `15 → 20 → 7` which has a sum of `42`.

---

## Approach

- Perform a **post-order traversal**.
- For each node:
  - Compute max path sum including **either left or right child**.
  - Track the maximum sum including **both children + node**.
- Maintain a **global max** variable to update the best path sum.

---

## Algorithm (Steps)

1. Define a recursive helper function:
   - Return the maximum path sum including current node + one child.
   - Ignore negative sums (treat them as 0).
2. At each node, calculate:
   - `current_max = node.val + left + right`
   - Update `global_max = max(global_max, current_max)`
3. Return `node.val + max(left, right)` for parent recursion.
4. Final answer = `global_max`.

---

## Time & Space Complexity

- **Time:** `O(N)` (each node visited once)
- **Space:** `O(H)` (recursion stack, `H` = tree height)

---

## Practice Links

- [LeetCode – Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
- [GeeksforGeeks – Maximum path sum in a binary tree](https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/)

---

## Video Explanations

- [YouTube – Maximum Path Sum Explained](https://www.youtube.com/watch?v=Hr5cWUld4vU)
