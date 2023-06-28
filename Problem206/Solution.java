class Solution {
    ListNode curr;
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        curr = dummy;

        reverse(head);

        return dummy.next;
    }


    private void reverse(ListNode node) {
        if (node == null) {
            return;
        }

        reverse(node.next);
        node.next = null;
        curr.next = node;
        curr = node;
    }
}