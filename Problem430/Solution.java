class Solution {
    Node current;

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node dummy = new Node();
        current = dummy;

        flattenDFS(head);

        dummy.next.prev = null;

        return dummy.next;
    }

    private void flattenDFS(Node node) {
        if (node == null) {
            return;
        }

        Node child = node.child;
        Node next = node.next;

        node.child = null;
        node.next = null;
        // Set Node
        current.next = node;
        node.prev = current;
        current = current.next;

        // Set child nodes.
        if (child != null) {
            flattenDFS(child);
        }

        // Set next nodes.
        if (next != null) {
            flattenDFS(next);
        }
    }
}