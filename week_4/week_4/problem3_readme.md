# Even Tree (Adobe)

## 📝 Problem Statement

You are given a tree (an undirected, connected graph without cycles) with **N nodes** and **N-1 edges**.  
The nodes are numbered from **1 to N**.

You need to remove the **maximum number of edges** such that each of the resulting connected components (subtrees) has an **even number of nodes**.

---

### Example 1

**Input:**
N = 10, M = 9
Edges:
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8

**Output:**
2

**Explanation:**  
By removing edges `(1,3)` and `(1,6)`, all components have even nodes.

---

### Example 2

**Input:**
N = 4, M = 3
Edges:
2 1
3 1
4 2

**Output:**
1

**Explanation:**  
Removing edge `(2,1)` splits the tree into two parts of size 2 each.

---

## ✅ Constraints

- `2 ≤ N ≤ 100`
- Tree has `N-1` edges.
- Each subtree after edge removal must have **even number of nodes**.

---

## 💡 Approach

### Key Idea:

- Use **DFS** to compute the size of each subtree.
- If a subtree size is **even**, then we can cut the edge connecting it to its parent.
- Count such edges.

---

### Steps:

1. Build adjacency list of the tree.
2. Run DFS from root (say node 1).
3. For each node:
   - Compute size of its subtree.
   - If a child subtree size is **even**, increment the cut count.
4. Return the total number of cuts.

---

## 🖥️ Java Solution

```java
import java.util.*;

public class EvenTree {
    static List<List<Integer>> graph;
    static int cuts = 0;

    public static int dfs(int node, int parent) {
        int size = 1; // include current node
        for (int child : graph.get(node)) {
            if (child != parent) {
                int subtreeSize = dfs(child, node);
                if (subtreeSize % 2 == 0) {
                    cuts++; // we can cut this edge
                } else {
                    size += subtreeSize;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1, -1);
        System.out.println(cuts);
    }
}
🔗 Related Links
HackerRank – Even Tree

DFS Tree Problems (GFG)
```
