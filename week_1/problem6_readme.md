# Problem 6: Find the Greatest Common Divisor (GCD) of N Numbers (Amazon)

## Problem Statement

You are given `n` integers. Find their **Greatest Common Divisor (GCD)** – the largest number that divides all integers without leaving a remainder.

---

## Example 1

**Input:**
3
42 56 14

**Output:**

14

**Explanation:**

- Factors of 42 → {1, 2, 3, 6, 7, 14, 21, 42}
- Factors of 56 → {1, 2, 4, 7, 8, 14, 28, 56}
- Factors of 14 → {1, 2, 7, 14}
- Greatest common factor = **14**

---

## Example 2

**Input:**

4
8 16 32 64

**Output:**

8

---

## Approach

- Use **Euclidean Algorithm**:
  - `gcd(a, b) = gcd(b, a % b)`
- Extend it to `n` numbers by applying gcd iteratively:

result = arr[0]
for i = 1 to n-1:
result = gcd(result, arr[i])

---

## Complexity

- **Time Complexity:** O(n log M), where M = maximum element in array
- **Space Complexity:** O(1) (only a few variables needed)

---

## References

- LeetCode – Find Greatest Common Divisor of Array
- GFG – GCD of N numbers
- Euclidean Algorithm (YouTube explanation)
