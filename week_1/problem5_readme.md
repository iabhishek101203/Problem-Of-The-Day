# Problem 5: Flood Fill Algorithm (Facebook)

## Problem Statement

Given an image as a 2D matrix of characters, a starting pixel `(sr, sc)`, and a new color `C`,
perform a **Flood Fill** operation: change the starting pixel’s color and all connected pixels
(connected 4-directionally) of the same original color into `C`.

---

## Example

**Input:**
image = [
['B', 'B', 'W'],
['W', 'W', 'W'],
['W', 'W', 'W'],
['B', 'B', 'B']
]
sr = 2, sc = 2
C = 'G'

**Output:**

[
['B', 'B', 'G'],
['G', 'G', 'G'],
['G', 'G', 'G'],
['B', 'B', 'B']
]

---

## Approach 1: DFS (Recursive)

1. Check bounds and color.
2. If pixel matches original color, change to new color.
3. Recurse in 4 directions.

---

## Approach 2: BFS (Iterative)

1. Use a queue to process pixels layer by layer.
2. Replace color and push valid neighbors into queue.

---

## Complexity

- **Time Complexity:** O(n \* m) (visit each cell at most once)
- **Space Complexity:**
  - DFS: O(n \* m) recursion stack (worst case)
  - BFS: O(n \* m) queue (worst case)

---

## References

- LeetCode #733 – Flood Fill
- GFG – Flood Fill Algorithm
- YouTube Explanations: DFS & BFS
