# Problem 4: Deep Clone a Linked List with Random Pointer (Snapchat)

## Problem Statement

You are given a linked list where each node has:

- `next` pointer → points to next node
- `random` pointer → points to any node in the list (or `null`)

Return a deep clone of the list, such that:

- Values are the same
- Structure of `next` and `random` is preserved
- Original and clone are separate objects

---

## Example

**Input:**
7 -> 13 -> 11 -> 10 -> 1
random: 13 → 7, 11 → 1, 10 → 11, 1 → 7

**Output:** A deep cloned list with the same structure.

---

## Approach 1: HashMap (O(n) Time, O(n) Space)

1. Traverse list, clone each node, store mapping: `original → cloned`.
2. Second pass: assign `next` and `random` using the map.

---

## Approach 2: O(1) Space (Optimized)

1. Interleave cloned nodes with original list.
2. Set random pointers of clones by using original’s random.
3. Separate the two lists.

---

## Complexity

- **Time Complexity:** O(n) for both approaches (two traversals).
- **Space Complexity:**
  - HashMap method: O(n)
  - Interleaving method: O(1) extra space

---

## References

- LeetCode #138 – Copy List with Random Pointer
- GFG – Clone a Linked List with Next and Random Pointer
- NeetCode / Take U Forward explanations
