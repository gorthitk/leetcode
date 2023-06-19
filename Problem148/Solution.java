
public class Solution
{
    public ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode mid = head, fast = head, prev = null;
        while (fast != null && fast.next != null)
        {
            prev = mid;
            mid = mid.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return merge(sortList(head), sortList(mid));
    }

    private ListNode merge(ListNode a, ListNode b)
    {
        ListNode dummy = new ListNode(-1);
        ListNode merge = dummy;
        while (a != null || b != null)
        {
            int a_val = a != null ? a.val : Integer.MAX_VALUE;
            int b_val = b != null ? b.val : Integer.MAX_VALUE;
            merge.next = a_val > b_val ? b : a;
            a = a_val > b_val ? a : a.next;
            b = a_val > b_val ? b.next : b;
            merge = merge.next;
        }
        return dummy.next;
    }
}