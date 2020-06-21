import java.util.HashMap;
import java.util.Map;

/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    private Map<Node, NodeCopy> lookup = new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root)
    {
        if (root == null)
        {
            return null;
        }

        if (!lookup.containsKey(root))
        {
            NodeCopy nodeCopy = new NodeCopy(root.val);
            lookup.put(root, nodeCopy);
            nodeCopy.left = copyRandomBinaryTree(root.left);
            nodeCopy.right = copyRandomBinaryTree(root.right);
            nodeCopy.random = copyRandomBinaryTree(root.random);


        }



        return lookup.get(root);
    }
}