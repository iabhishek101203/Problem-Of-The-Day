package week_2;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        int currentMax = node.val + left + right;

        maxSum = Math.max(maxSum, currentMax);

        return node.val + Math.max(left, right);
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();
        System.out.println("Maximum Path Sum: " + sol.maxPathSum(root));
    }
}
