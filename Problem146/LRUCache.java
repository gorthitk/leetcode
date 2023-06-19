import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private static class CacheNode {
        int key;
        int val;
        CacheNode next;
        CacheNode previous;

        CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, CacheNode> nodeByKey;
    private CacheNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeByKey = new HashMap<>();

        this.tail = new CacheNode(-1, -1);
        this.head = new CacheNode(-1, -1);

        tail.previous = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!nodeByKey.containsKey(key)) {
            return -1;
        }

        CacheNode node = nodeByKey.get(key);
        removeNode(node);
        addNode(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (nodeByKey.containsKey(key)) {
            removeNode(nodeByKey.get(key));
        }

        CacheNode node = new CacheNode(key, value);
        nodeByKey.put(key,node);
        addNode(node);

        if (nodeByKey.size() > capacity) {
            CacheNode toDelete = head.next;
            removeNode(toDelete);
            nodeByKey.remove(toDelete.key);
        }
    }


    private void addNode(CacheNode node) {
        CacheNode prev = tail.previous;
        prev.next = node;
        node.previous = prev;
        node.next = tail;
        tail.previous = node;

    }

    private void removeNode(CacheNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}

