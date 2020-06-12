public class Solution
{
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode node = head.next;
        head.next = null;
        ListNode reverse = reverseList(node);
        node.next = head;
        return reverse;
    }
}