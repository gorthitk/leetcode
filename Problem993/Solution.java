class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depthX = -1;
        int depthY = -1;
        TreeNode pX = null;
        TreeNode pY = null;

        int steps = 0;
        while(!queue.isEmpty() && pX == null && pY == null) {
            int sz = queue.size();
            while(sz-- > 0) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }

                if ((curr.left != null && curr.left.val == x) || (curr.right != null && curr.right.val == x)) {
                    depthX = steps;
                    pX = curr;
                }

                if ((curr.left != null && curr.left.val == y) || (curr.right != null && curr.right.val == y)) {
                    depthY = steps;
                    pY = curr;
                }
            }

            steps++;
        }

        return pX != null && pY != null && pX != pY && depthX == depthY;
    }
}