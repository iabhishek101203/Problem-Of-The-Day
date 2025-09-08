# Majority Element (MongoDB)

## 📝 Problem Statement

You are given a list of integers. A **majority element** in a list is defined as the element that
appears more than ⌊n/2⌋ times, where n is the length of the list.

You can assume that such an element always exists.

### Example

Input:
7
1 2 1 1 3 4 0

Output:
1

## ✅ Constraints

- 1 ≤ n ≤ 10^5
- -10^9 ≤ A[i] ≤ 10^9
- A majority element **always exists**

---

## 💡 Approaches

### Approach 1: HashMap / Dictionary

- Count frequencies of each element.
- Return the one with frequency > n/2.
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### Approach 2: Boyer–Moore Majority Vote (Efficient 🚀)

- Maintain a candidate and a counter.
- Traverse list:
  - If counter is 0, set candidate = num.
  - If num == candidate, increment counter. Else decrement counter.
- Final candidate is the majority element.
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

---

## 🖥️ Java Solution (Boyer–Moore)

```java
import java.util.*;

public class Main {
    public static int findMajorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        System.out.println(findMajorityElement(nums));
    }
}
🔗 Related Links
LeetCode 169 – Majority Element

yaml
Copy code
```
