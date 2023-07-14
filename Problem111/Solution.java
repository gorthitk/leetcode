import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();

            while (sz-- > 0) {
                TreeNode curr = queue.poll();

                if (curr.left == null && curr.right == null) {
                    return depth;
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            depth++;
        }
        return -1;
    }
}