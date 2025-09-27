# Problem of the Week – Minimum Radio Broadcast Range

**🏢 Company:** Spotify  
**🎯 Difficulty:** Medium  
**📌 Topics:** Greedy, Arrays, Binary Search

---

## 📖 Problem Statement

Spotify wants to set up radio transmitters to cover all houses along a straight road.  
Each transmitter can cover houses within a certain range `R` (both left and right).

You are given the positions of houses on the road.  
Your task is to determine the **minimum broadcast range R** required so that **all houses can be covered using exactly `K` transmitters**.

---

## 🖊 Input Format

- First line: Two integers `N` (number of houses), `K` (number of transmitters).
- Second line: `N` space-separated integers (positions of houses).

## 🖊 Output Format

- Print the **minimum broadcast range R** (as an integer).

---

## ⚡ Constraints

- `1 ≤ N ≤ 10^5`
- `1 ≤ K ≤ N`
- `1 ≤ positions[i] ≤ 10^9`
- House positions are distinct but not necessarily sorted.

---

## 💡 Examples

### Example 1

**Input**  
5 2
1 2 8 4 9

**Output**  
3

**Explanation**

- Sort houses: `[1, 2, 4, 8, 9]`
- With `R = 3`:
  - First transmitter at house `2` → covers `[1–5]`
  - Second transmitter at house `8` → covers `[5–11]`
- All houses are covered with range `3`.

---

### Example 2

**Input**  
4 1
1 2 3 4

**Output**  
2

**Explanation**

- One transmitter must cover all houses.
- Place at `2` → covers `[0–4]`
- Place at `3` → covers `[1–5]`
- Minimum range needed is `2`.

---

## 🔑 Approaches

### 1. Greedy + Binary Search (Efficient O(N log(maxPos)))

1. **Sort** the house positions.
2. **Binary search** on possible range `R` (from `0` to `max - min`).
3. For each `R`, check if `K` transmitters can cover all houses:
   - Place a transmitter at the farthest house it can cover.
   - Repeat until all are covered or `K` is exceeded.

---

## ⏱ Complexity

- Sorting: `O(N log N)`
- Binary search over range: `O(log(maxPos))`
- Coverage check: `O(N)`
- **Total:** `O(N log N + N log(maxPos))`

---

## 🔗 References

- [Greedy Placement Explanation – GeeksforGeeks](https://www.geeksforgeeks.org/aggressive-cows/)
- [Similar LeetCode Problem – Aggressive Cows Variant](https://leetcode.com/discuss/interview-question/algorithms/124676/aggressive-cows-binary-search)
