public class Solution
{
    public ListNode removeElements(ListNode head, int val)
    {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head != null)
        {
            if (head.val != val)
            {
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        // Tail
        if (p.next != null && p.next.val == val)
            p.next = null;
        return dummy.next;
    }
}