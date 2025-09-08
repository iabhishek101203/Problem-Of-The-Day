# Reverse Words with Delimiters (Facebook)

## 📝 Problem Statement

You are given a string `S` consisting of **words** (only lowercase alphabets) and **delimiters** (like `/`, `:`, etc.).  
Your task is to **reverse the words in the string while preserving the delimiters in their original relative positions**.

### Examples

**Input:**
hello/world:here

makefile
Copy code
**Output:**
here/world:hello

**Input:**
hello/world:here/

**Output:**
here/world:hello/

**Input:**
hello//world:here

**Output:**
here//world:hello

---

## ✅ Constraints

- Input string contains only:
  - Lowercase words (`a–z`)
  - Delimiters (`/`, `:`, etc.)
- Multiple delimiters may appear consecutively.
- Delimiters **must stay in the same relative order**.
- Words must be reversed in order.

---

## 💡 Approaches

### Approach 1: Regex Tokenization + Stack

1. Split string into tokens:
   - Word tokens (`[a-z]+`)
   - Delimiter tokens (`[^a-z]+`)
2. Push all words into a stack.
3. Rebuild string by popping words from the stack and keeping delimiters unchanged.

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

---

### Approach 2: Manual Parse (Two-pass)

1. First pass: Collect all words in a list.
2. Reverse the list of words.
3. Second pass: Traverse string again.
   - If encountering a word → replace with next reversed word.
   - If encountering a delimiter → keep it as-is.

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

---

## 🖥️ Java Solution (Regex + Stack)

```java
import java.util.*;
import java.util.regex.*;

public class ReverseWordsWithDelimiters {
    public static String reverseWordsPreserveDelimiters(String s) {
        if (s == null || s.isEmpty()) return s;

        Pattern p = Pattern.compile("[a-z]+|[^a-z]+");
        Matcher m = p.matcher(s);

        List<String> tokens = new ArrayList<>();
        List<Boolean> isWord = new ArrayList<>();

        while (m.find()) {
            String t = m.group();
            tokens.add(t);
            isWord.add(Character.isLetter(t.charAt(0)));
        }

        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.size(); i++) {
            if (isWord.get(i)) stack.push(tokens.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.size(); i++) {
            if (isWord.get(i)) sb.append(stack.pop());
            else sb.append(tokens.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(reverseWordsPreserveDelimiters(input));
    }
}
🔗 Related Links
GeeksforGeeks – Reverse Words with Delimiters

LeetCode Discuss – Similar Problems
```
