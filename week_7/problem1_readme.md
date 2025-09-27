# Problem of the Week – Substring with Concatenation of All Words

**🏢 Company:** Dropbox  
**🎯 Difficulty:** Hard  
**📌 Topics:** Hashing, Sliding Window, String Matching, Two Pointers

---

## 📖 Problem Statement

You are given a string `s` and a list of words `words`, where each word in `words` has the same length.  
Your task is to find all starting indices of substrings in `s` that form a concatenation of every word in `words` **exactly once** (without any extra characters in between).  
If no such substring exists, return an empty list.

The order of indices in the output does not matter.

---

## 🖊 Input Format

- A string `s`.
- A list of words `words` (all words have the same length).

## 🖊 Output Format

- A list of integers representing all starting indices of valid substrings.

---

## ⚡ Constraints

- `1 <= len(s) <= 10^5`
- `1 <= len(words) <= 5000`
- Each word has length `k` such that `1 <= k <= 10`.

---

## 💡 Examples

### Example 1

**Input**  
s = "dogcatcatcodecatdog"
words = ["cat", "dog"]

markdown
**Output**  
[0, 13]

markdown
**Explanation**

- At index `0`, substring `"dogcat"` contains `"dog" + "cat"`.
- At index `13`, substring `"catdog"` contains `"cat" + "dog"`.

### Example 2

**Input**  
s = "barfoobazbitbyte"
words = ["dog", "cat"]

markdown

**Output**  
[]

markdown
**Explanation**  
No substring in `s` matches concatenation of `"dog"` and `"cat"`.

---

## 🔑 Approaches

### 1. Brute Force (❌ Too Slow)

- Generate all substrings of length `len(words) * wordLen`.
- Check if substring contains all words.
- Time: `O(N * numWords * wordLen)` worst case.

### 2. Efficient Sliding Window + HashMap ✅

- Use frequency map of words.
- Slide over string with step size = `wordLen`.
- Track words inside window using a `seen` HashMap.
- Adjust window when extra/unexpected word appears.

**Time Complexity:** `O(N)`  
**Space Complexity:** `O(numWords * wordLen)`

---

## 🔗 References

- [LeetCode 30 – Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)
- [GeeksforGeeks – Find all starting indices of concatenated words](https://www.geeksforgeeks.org/find-starting-indices-substrings-formed-concatenation-given-words/)
