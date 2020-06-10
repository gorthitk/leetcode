import java.util.Stack;

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