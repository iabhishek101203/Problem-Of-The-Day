# Problem 1: Count Univalue Subtrees

**Company Tag:** Common FAANG Interview Problem  
**Difficulty:** Medium

---

## 📌 Problem Statement

Given the root of a binary tree, return the number of **univalue subtrees**.

A **univalue subtree** is a subtree where **all nodes have the same value**.

---

## 📂 Example

### Input:

5
/ \
1 5
/ \ \
5 5 5

### Output:

4

### Explanation:

The 4 univalue subtrees are:

- The left child with value `5`
- The right child with value `5`
- The left-right child with value `5`
- The entire right subtree rooted at `5`

---

## 🔒 Constraints

- The number of nodes in the tree is in the range **[0, 1000]**
- `-1000 <= Node.val <= 1000`

---

## 💡 Approach

We solve this using **DFS (post-order traversal)**:

1. A node is the root of a univalue subtree if:

   - Its left subtree is a univalue subtree
   - Its right subtree is a univalue subtree
   - Both children (if they exist) have values equal to the node’s value

2. If the above holds true, increment the counter.

---

## ✅ Java Solution

```java
class Solution {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }

    private boolean dfs(TreeNode node) {
        if (node == null) return true;

        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        if (!left || !right) return false;

        if (node.left != null && node.left.val != node.val) return false;
        if (node.right != null && node.right.val != node.val) return false;

        count++;
        return true;
    }
}

⏱ Complexity Analysis

Time Complexity: O(n) → each node is visited once

Space Complexity: O(h) → recursion stack, where h is the height of the tree

🧪 Edge Cases Tested

Empty tree → output 0

Single-node tree → output 1 (every single node is a univalue subtree)

All nodes have same value → output equals total number of nodes


---

This is a **complete polished README** (problem statement → examples → approach → solution → complexity → edge cases).

👉 Do you want me to now prepare the **Problem 2 (`Word Search`) README** in the same format, so your r
```
