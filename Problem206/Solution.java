class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode reverse = reverseList(head.next);

        next.next = head;
        head.next = null;

        return reverse;
    }
}