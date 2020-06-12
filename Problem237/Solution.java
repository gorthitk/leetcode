/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public void deleteNode(ListNode node)
    {
        if (node.next != null)
        {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}