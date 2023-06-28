import java.util.ArrayList;
import java.util.List;

class BSTIterator {

    List<Integer> queue;
    int idx = 0;

    public BSTIterator(TreeNode root) {
        this.queue = new ArrayList<>();
        this.idx = 0;
        inOrder(root);
    }

    public int next() {
        return queue.get(idx++);
    }

    public boolean hasNext() {
        return idx < queue.size();
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        this.queue.add(node.val);
        inOrder(node.right);
    }
}