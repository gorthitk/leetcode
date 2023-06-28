import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Node, Node> nodesMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (nodesMap.containsKey(head)) {
            return nodesMap.get(head);
        }

        Node copy = new Node(head.val);
        nodesMap.put(head, copy);

        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);

        return copy;
    }
}