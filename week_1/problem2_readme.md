# Problem 2 – Word Search in 2D Matrix

### 📌 Problem Statement

Given a 2D grid of characters and a target word, determine if the word exists in the grid.

- **Simple Version:** Search left-to-right (rows) or top-to-bottom (columns).
- **Extended (LeetCode Version):** Word can be constructed by moving up, down, left, or right (no diagonal, no reuse of same cell).

---

### ✅ Example

Input:board = [
['F','A','C','I'],
['O','B','Q','P'],
['A','N','O','B'],
['M','A','S','S']
]
word = "FOAM"

Output:true

Explanation: `"FOAM"` appears in the first column → top to bottom.  
`"MASS"` appears in the last row → left to right.

---

### 📌 Approach 1 – Simple Row/Column Search

- Traverse each row and form a string.
- Traverse each column and form a string.
- Check if the word exists.

**Time Complexity:** `O(M×N)`  
**Space Complexity:** `O(1)`

👉 Implemented in **`problem2_WordSearch.java`**

---

### 📌 Approach 2 – DFS Backtracking (LeetCode Word Search)

- Start DFS from every cell that matches first character.
- Explore 4 neighbors recursively (up, down, left, right).
- Mark cell visited temporarily (`'#'`), backtrack later.
- Return true if full word is matched.

**Time Complexity:** `O(M×N×4^L)` (L = length of word)  
**Space Complexity:** `O(L)` recursion stack

👉 Implemented in **`problem2_WordSearch_DFS.java`**

---

### ✨ Practice Links

- [Leetcode – Word Search I](https://leetcode.com/problems/word-search/)
- [GeeksforGeeks – Search a Word in 2D Grid of Characters](https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/)
