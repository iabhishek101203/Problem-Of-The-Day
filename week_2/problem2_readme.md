# Problem 2: Nim (Misère Version) — Determine if First Player Has a Forced Win

**Company:** Google

## Problem Description

The game of Nim is played on several heaps of stones. Two players alternate turns. On each turn a player removes one or more stones from exactly one heap.  
In this variant, the player who takes the **last stone loses** (misère Nim).

Given three non-zero starting heap sizes `[a, b, c]`, decide whether the first player (who moves first) has a forced win assuming both players play optimally.

---

### Input Format

- A list/array of three positive integers: `[a, b, c]`

### Output Format

- `True` if the first player has a forced win
- `False` otherwise

---

### Examples

#### Example 1

**Input:**
[3, 4, 5]

**Output:**

True

#### Example 2

**Input:**

[1, 1, 1]

**Output:**

False

#### Example 3

**Input:**

[1, 1, 2]

**Output:**

True

---

### Key Insight

- If **all heaps are size 1**:
  - First player **wins** if number of heaps is **even**.
  - First player **loses** if number of heaps is **odd**.
- Otherwise (if some heap ≥ 2), play reduces to **normal Nim**:
  - Compute XOR of all heap sizes.
  - If `xor != 0` → first player wins.
  - Else → first player loses.

---

### Constraints

- Each heap size > 0
- Here we assume 3 heaps, but formula works for `n` heaps.

---

### Time Complexity

- **O(1)** for 3 heaps
- **O(n)** for n heaps

---

### Practice Links

- [LeetCode – Nim Game](https://leetcode.com/problems/nim-game/)
- [GeeksforGeeks – Game of Nim](https://www.geeksforgeeks.org/nim-game-its-variants/)

### Video Explanation

- YouTube – _Nim Game & Misère Nim Explained_
