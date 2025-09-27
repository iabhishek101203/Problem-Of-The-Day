# Problem of the Week – The 24 Game

**🏢 Company:** Twitter | PayPal  
**🎯 Difficulty:** Hard  
**📌 Topics:** Recursion, Backtracking, Expression Evaluation

---

## 📖 Problem Statement

The **24 Game** is a classic puzzle where you are given **4 integers (1–9)**.  
Your goal is to determine if it is possible to reach exactly `24` using:

- Arithmetic operators: `+`, `-`, `*`, `/`
- Any valid arrangement of parentheses

Return **true** if 24 can be formed, otherwise **false**.

---

## 🖊 Input Format

- Four space-separated integers `a1 a2 a3 a4` (each between 1 and 9).

## 🖊 Output Format

- Print `true` if 24 can be formed, else `false`.

---

## ⚡ Constraints

- Exactly **4 integers** will be provided.
- Each integer is between `1` and `9`.
- Division must be treated as **floating-point division**.
- A tolerance (`1e-6`) is acceptable for floating-point comparisons.

---

## 💡 Examples

### Example 1

**Input**  
5 2 7 8

**Output**  
true

**Explanation**  
One possible solution:  
(5 × 2 - 7) × 8 = 24

---

### Example 2

**Input**  
1 1 1 1

**Output**  
false

**Explanation**  
No valid arrangement of operators and parentheses can yield 24.

---

## 🔑 Approaches

### 1. Brute Force Enumeration

- Generate all **permutations** of the 4 numbers.
- Try all **operator combinations** (`+`, `-`, `*`, `/`).
- Try all possible **parenthesizations**.
- If any expression evaluates to 24 → return true.
- Complexity is high, but feasible since `N=4`.

---

### 2. Recursion + Backtracking (Efficient)

1. Treat it as a **search problem**.
2. At each step, pick two numbers `a` and `b`.
3. Apply each operation (`a+b`, `a-b`, `b-a`, `a*b`, `a/b`, `b/a`) if valid.
4. Recurse with the reduced list of numbers.
5. Base case: when only one number remains, check if it is close to 24.

---

## ⏱ Complexity

- Number of permutations: `4! = 24`
- Number of operator choices per step: up to `6`
- Recursive branching makes it exponential, but **tractable for N=4**.

---

## 🔗 References

- [LeetCode 679 – 24 Game](https://leetcode.com/problems/24-game/)
- [GeeksforGeeks – The 24 Game Problem](https://www.geeksforgeeks.org/24-game-problem/)
