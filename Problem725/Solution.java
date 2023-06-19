
class Solution
{
    public ListNode[] splitListToParts(ListNode root, int k)
    {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        for (ListNode n = root; n != null; n = n.next)
        {
            len++;
        }
        int eachListContains = len / k, extra = len % k;
        ListNode node = root, prev = null;
        for (int i = 0; i < k && node != null; i++, extra--)
        {
            parts[i] = node;
            int partContains = eachListContains + (extra > 0 ? 1 : 0);
            for (int j = 0; j < partContains; j++)
            {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return parts;
    }
}