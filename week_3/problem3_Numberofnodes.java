package week_3;

import java.util.*;

public class problem3_Numberofnodes {
    static List<List<Integer>> adj;
    static int removableEdges = 0;

    public static int dfs(int node, int parent) {
        int subtreeSize = 1;

        for (int child : adj.get(node)) {
            if (child != parent) {
                int childSize = dfs(child, node);

                if (childSize % 2 == 0) {
                    removableEdges++;
                } else {
                    subtreeSize += childSize;
                }
            }
        }

        return subtreeSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of nodes
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(1, -1); // start DFS from node 1 (assuming tree is 1-indexed)
        System.out.println(removableEdges);
    }
}
