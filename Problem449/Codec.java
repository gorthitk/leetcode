import java.util.*;

public class Codec
{

    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            sb.append(node.val).append(",");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data)
    {
        if (data == null)
            return null;
        String[] nodeValues = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String str : nodeValues)
        {
            queue.offer(Integer.parseInt(str));
        }
        return getNode(queue);
    }

    private TreeNode getNode(Queue<Integer> queue)
    {
        if (queue.isEmpty())
            return null;
        int rootVal = queue.poll();
        TreeNode root = new TreeNode(rootVal);
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();
        while (!queue.isEmpty())
        {
            if (queue.peek() < rootVal)
            {
                leftQueue.offer(queue.poll());
            }
            else
            {
                rightQueue.offer(queue.poll());
            }
        }
        root.left = getNode(leftQueue);
        root.right = getNode(rightQueue);
        return root;
    }

    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }
}