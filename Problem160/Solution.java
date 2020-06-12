/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        int lenA = 0, lenB = 0;
        ListNode a = headA;
        while (a != null)
        {
            a = a.next;
            lenA++;
        }
        ListNode b = headB;
        while (b != null)
        {
            b = b.next;
            lenB++;
        }
        int diff = Math.abs(lenA - lenB);
        a = headA;
        b = headB;
        if (diff > 0)
        {
            if (lenA > lenB)
            {
                while (diff > 0)
                {
                    a = a.next;
                    diff--;
                }
            }
            else
            {
                while (diff > 0)
                {
                    b = b.next;
                    diff--;
                }
            }
        }
        while (a != null)
        {
            if (a == b)
            {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}