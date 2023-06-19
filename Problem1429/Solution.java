

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FirstUnique
{
    private final Map<Integer, Node> nodeMap = new HashMap<>();
    private final Set<Integer> duplicates = new HashSet<>();
    Node root;
    Node tail;

    public FirstUnique(int[] nums)
    {
        for (int num : nums)
        {
            add(num);
        }
    }

    public int showFirstUnique()
    {
        if (root == null)
        {
            return -1;
        }
        return root.value;
    }

    public void add(int value)
    {
        if (nodeMap.containsKey(value))
        {
            Node node = nodeMap.get(value);
            nodeMap.remove(value);
            if (node == root)
            {
                root = node.next;
            }
            if (node == tail)
            {
                tail = node.previous;
            }
            if (node.previous != null)
            {
                node.previous.next = node.next;
            }
            if (node.next != null)
            {
                node.next.previous = node.previous;
            }
            duplicates.add(value);
        }
        else if (!duplicates.contains(value))
        {
            Node node = new Node(value);
            nodeMap.put(value, node);
            if (root == null)
            {
                root = node;
                tail = node;
            }
            else
            {
                tail.next = node;
                node.previous = tail;
                tail = node;
            }
        }
    }

    class Node
    {
        private final int value;
        Node next, previous;

        Node(int value)
        {
            this.value = value;
        }
    }
}