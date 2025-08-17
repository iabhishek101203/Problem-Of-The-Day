package week_1;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class problem4_CloneLinkedList {

    // Approach 1: Using HashMap (O(n) time, O(n) space)
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: Clone nodes and store mapping
        java.util.Map<Node, Node> map = new java.util.HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers
        curr = head;
        while (curr != null) {
            Node clone = map.get(curr);
            clone.next = map.get(curr.next); // clone next
            clone.random = map.get(curr.random); // clone random
            curr = curr.next;
        }

        return map.get(head);
    }

    // Approach 2: O(1) Space (Interleaving method)
    public Node copyRandomListOptimized(Node head) {
        if (head == null)
            return null;

        Node curr = head;

        // Step 1: Insert cloned nodes in between original nodes
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Set random pointers for clones
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and cloned lists
        curr = head;
        Node dummy = new Node(0);
        Node copy = dummy;

        while (curr != null) {
            Node clone = curr.next;
            curr.next = clone.next;
            copy.next = clone;
            copy = clone;
            curr = curr.next;
        }

        return dummy.next;
    }

    // Quick test
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        problem4_CloneLinkedList solution = new problem4_CloneLinkedList();

        Node cloned = solution.copyRandomListOptimized(node1);
        System.out.println("Cloned head value: " + cloned.val); // should print 7
        System.out.println("Cloned second node random points to: " +
                (cloned.next.random != null ? cloned.next.random.val : "null")); // should print 7
    }
}
