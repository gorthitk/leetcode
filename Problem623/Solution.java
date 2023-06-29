class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        dfs(root, null, true, val, 1, depth);

        return root;
    }

    private void dfs(TreeNode curr, TreeNode p, boolean left, int val, int d, int depth) {
        if (d == depth) {
            if (left) {
                p.left = new TreeNode(val);
                p.left.left = curr;
            } else {
                p.right = new TreeNode(val);
                p.right.right = curr;
            }
            return;
        }

        if (curr == null) {
            return;
        }

        dfs(curr.left, curr, true, val, d + 1, depth);
        dfs(curr.right, curr, false, val, d + 1, depth);
    }
}