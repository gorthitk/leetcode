/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public boolean isPalindrome(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> firstHalf = new Stack<>();
        while (fast != null && fast.next != null)
        {
            firstHalf.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
        {
            slow = slow.next;
        }
        while (slow != null)
        {
            if (slow.val != firstHalf.peek())
            {
                return false;
            }
            firstHalf.pop();
            slow = slow.next;
        }
        return true;
    }
}