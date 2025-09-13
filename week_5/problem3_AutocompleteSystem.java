package week_5;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert word into trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    // Get words with given prefix
    public List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = root;

        // Traverse prefix
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c))
                return results; // no matches
            node = node.children.get(c);
        }

        // Collect completions
        dfs(node, new StringBuilder(prefix), results);
        return results;
    }

    private void dfs(TrieNode node, StringBuilder path, List<String> results) {
        if (node.isEndOfWord)
            results.add(path.toString());
        for (char c : node.children.keySet()) {
            path.append(c);
            dfs(node.children.get(c), path, results);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

public class problem3_AutocompleteSystem {
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
