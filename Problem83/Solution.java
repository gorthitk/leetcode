public class Solution
{
    public ListNode deleteDuplicates(ListNode head)
    {
        ListNode p = head;
        while (p != null)
        {
            ListNode next = p.next;
            while (next != null && next.val == p.val)
                next = next.next;
            p.next = next;
            p = p.next;
        }
        return head;
    }
}