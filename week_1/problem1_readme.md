# Problem 1: Count Unival Subtrees

## Problem Description

A **unival tree** is a subtree in which all nodes have the same value.

You are given the root of a binary tree. Your task is to count how many unival subtrees exist.

> A single node is considered a unival subtree by default.

---

## Input Format

Each node contains:

- An integer value
- Left and right children

---

## Output Format

Print a single integer: the number of unival subtrees.

---

## Constraints

- Number of nodes ≤ 1000
- Node values can be any integer (positive or negative)

---

## Sample Tree

    0

/ \
 1 0
/ \
 1 0
/ \
 1 1

### Output:

5

### Explanation:

The 5 unival subtrees are:

- Left child with value `1`
- Rightmost leaf with value `0`
- Two leaf `1`s in the subtree
- The subtree rooted at the node with both children `1`

---

## Approach

We use **post-order DFS** to:

- Recursively check the left and right subtrees
- Determine if current node is a unival subtree by checking:
  - Left and right subtrees are unival
  - Current node matches child values (if they exist)

We maintain a count variable to track the number of unival subtrees.

---

## Time and Space Complexity

| Metric           | Value                       |
| ---------------- | --------------------------- |
| Time Complexity  | O(N)                        |
| Space Complexity | O(H), where H = tree height |

---

## Code Link

[Problem1_CountUnivalSubtrees.java](./Problem1_CountUnivalSubtrees.java)

---

## Practice Links

- [GeeksforGeeks – Count Unival Subtrees](https://www.geeksforgeeks.org/count-single-valued-subtrees/)
- [Leetcode – Problem 250](https://leetcode.com/problems/count-univalue-subtrees/)
- [YouTube – Count Univalue Subtrees](https://www.youtube.com/results?search_query=Count+Univalue+Subtrees+DFS)
