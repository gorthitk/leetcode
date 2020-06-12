/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class Solution
{
    public void connect(TreeLinkNode root)
    {
        Queue<TreeLinkNode> stack = new LinkedList<>();
        if (root != null)
        {
            stack.add(root);
        }
        while (!stack.isEmpty())
        {
            Queue<TreeLinkNode> childNodesStack = new LinkedList();
            TreeLinkNode prev = stack.poll();
            if (prev.left != null)
            {
                childNodesStack.add(prev.left);
            }
            if (prev.right != null)
            {
                childNodesStack.add(prev.right);
            }
            while (!stack.isEmpty())
            {
                TreeLinkNode next = stack.poll();
                prev.next = next;
                prev = next;
                if (next.left != null)
                {
                    childNodesStack.add(next.left);
                }
                if (next.right != null)
                {
                    childNodesStack.add(next.right);
                }
            }
            stack = childNodesStack;
        }
    }
}