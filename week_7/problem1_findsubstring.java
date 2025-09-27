package week_7;

import java.util.*;

public class problem1_findsubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int n = s.length();

        // Frequency map of given words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        // Loop over wordLen possible starting offsets
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();

            // Move window in wordLen steps
            for (int j = i; j + wordLen <= n; j += wordLen) {
                String word = s.substring(j, j + wordLen);

                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // Shrink window if word frequency exceeded
                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }

        return result;
    }

    // --- Quick test ---
    public static void main(String[] args) {
        problem1_findsubstring sol = new problem1_findsubstring();
        System.out.println(sol.findSubstring("dogcatcatcodecatdog", new String[] { "cat", "dog" })); // [0, 13]
        System.out.println(sol.findSubstring("barfoobazbitbyte", new String[] { "dog", "cat" })); // []
        System.out.println(sol.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" })); // [0, 9]
    }
}
