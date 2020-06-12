/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public void printLinkedListInReverse(ImmutableListNode head)
    {
        if (head == null)
        {
            return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}