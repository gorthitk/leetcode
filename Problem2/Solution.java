public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode sum = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
           int num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
           sum.next = new ListNode(num%10);
           carry = num/10;
           l1 = l1 != null ? l1.next : null;
           l2 = l2 != null ? l2.next : null;
           sum = sum.next;
        }
        return dummy.next;
    }
}