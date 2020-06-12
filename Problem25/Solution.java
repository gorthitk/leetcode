/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode ptr = head;
        int count = k;
        ListNode prev = null;
        while (ptr != null && count > 0)
        {
            prev = ptr;
            ptr = ptr.next;
            count--;
        }
        if (count != 0)
        {
            return head;
        }
        prev.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(ptr, k);
        return newHead;
    }

    private ListNode reverse(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverse(next);
        next.next = head;
        return newHead;
    }
}