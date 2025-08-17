package week_1;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class problem1_CountUnivalSubtrees {

    static class Count {
        int value = 0;
    }

    public static int countUnivalSubtrees(Node root) {
        Count count = new Count();
        isUnival(root, count);
        return count.value;
    }

    private static boolean isUnival(Node node, Count count) {
        if (node == null)
            return true;

        boolean left = isUnival(node.left, count);
        boolean right = isUnival(node.right, count);

        if (!left || !right)
            return false;

        if (node.left != null && node.left.val != node.val)
            return false;

        if (node.right != null && node.right.val != node.val)
            return false;

        count.value++;
        return true;
    }

    public static void main(String[] args) {

        Node root = new Node(0,
                new Node(1),
                new Node(0,
                        new Node(1, new Node(1), new Node(1)),
                        new Node(0)));

        System.out.println("Number of Unival Subtrees: " + countUnivalSubtrees(root)); // Output: 5
    }
}
