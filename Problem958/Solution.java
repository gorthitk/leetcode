import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isLast = false;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                isLast = true;
            } else {
                if (isLast) {
                    return false;
                }
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }


        return true;
    }
}