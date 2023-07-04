class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;

            return node;
        }

        Node prev = head, curr = head.next;

        while (true) {
            if (prev.val < curr.val) {
                if (insertVal >= prev.val && insertVal <= curr.val) {
                    prev.next = new Node(insertVal, curr);
                    return head;
                }
            } else if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    prev.next = new Node(insertVal, curr);
                    return head;
                }
            }

            prev = curr;
            curr = curr.next;

            // All values are equal.
            if (prev == head) {
                break;
            }
        }



        // List has equal values.
        prev.next = new Node(insertVal, curr);
        return head;
    }
}