class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();

        ListNode odd = dummy1;
        ListNode even = dummy2;


        int i = 1;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = null;
            if (i % 2 == 0) {
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }

            i++;
            curr = tmp;
        }

        odd.next = dummy2.next;
        return dummy1.next;
    }
}