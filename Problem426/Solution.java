class Solution {
    private Node head = null;
    private Node tail = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        helper(root);

        head.left = tail;
        tail.right = head;

        return head;
    }

    private void helper(Node node) {
        if (node == null) {
            return;
        }

        Node right = node.right;
        Node left = node.left;

        helper(left);

        node.left = null;
        node.right = null;

        if (head == null) {
            head = node;
            tail = node;

            head.right = tail;
            tail.left = head;
        } else {
            tail.right = node;
            node.left = tail;

            tail = tail.right;
        }

        helper(right);
    }
}