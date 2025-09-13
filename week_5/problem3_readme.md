Problem 3 – Autocomplete System

Company: Twitter
Difficulty: Medium
Topic: Strings, Trie, Hashing

📌 Scenario

Autocomplete is a popular feature used in Twitter, Google, IDEs, and messaging apps.

When a user starts typing, the system suggests completions from a known dictionary.

Your task is to implement an autocomplete system that returns all words from a dictionary that begin with a given prefix.

📌 Problem Statement

You are given:

A query string s.

A dictionary of words dict[].

Return all strings in dict that have s as a prefix.

💡 Hint: Building a Trie (prefix tree) enables faster lookups compared to linear search.

🔹 Input Format

First line: Integer N (number of words in dictionary).

Second line: N space-separated strings (the dictionary).

Third line: A string s (the query prefix).

🔹 Output Format

List of strings from the dictionary that start with prefix s.

🔹 Constraints

1 ≤ N ≤ 10^5

Each word length ≤ 50

Query string length ≤ 50

🔹 Sample Input / Output
Sample Input 0
3
dog deer deal
de

Sample Output 0
deer deal

🔑 Approaches

1. Brute Force Search

Iterate over all dictionary words.

Check if each word starts with prefix s.

Collect matches.

Complexity:

Time: O(N \* L) (N = words, L = prefix length)

Space: O(1)

2. Trie (Prefix Tree) Approach – Efficient ✅

Insert all dictionary words into a Trie.

Traverse Trie nodes according to prefix s.

From that node, perform DFS/BFS to collect completions.

Complexity:

Preprocessing: O(N \* M) (M = average word length)

Lookup: O(L + K) (L = prefix length, K = number of results)

Space: O(N \* M)

💻 Java Solution
import java.util.\*;

class TrieNode {
Map<Character, TrieNode> children = new HashMap<>();
boolean isEndOfWord;
}

class Trie {
private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    // Autocomplete suggestions for given prefix
    public List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = root;

        // Traverse to prefix node
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return results; // no matches
            node = node.children.get(c);
        }

        // Collect words from this node
        dfs(node, new StringBuilder(prefix), results);
        return results;
    }

    private void dfs(TrieNode node, StringBuilder path, List<String> results) {
        if (node.isEndOfWord) results.add(path.toString());
        for (char c : node.children.keySet()) {
            path.append(c);
            dfs(node.children.get(c), path, results);
            path.deleteCharAt(path.length() - 1);
        }
    }

}

public class AutocompleteSystem {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(sc.next());
        }
        String prefix = sc.next();

        List<String> suggestions = trie.autocomplete(prefix);
        for (String word : suggestions) {
            System.out.print(word + " ");
        }
    }

}

✅ Key Takeaway:

Brute force is simple but slow for large input sizes.

Trie-based solution is efficient and scalable, used in real-world autocomplete systems.
