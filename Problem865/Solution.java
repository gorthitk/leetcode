class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = findMaxdepth(root);
        return find(root, 1, maxDepth);
    }

    private TreeNode find(TreeNode node, int curr, int max) {
        if (node == null) {
            return null;
        }

        if (curr == max) {
            return node;
        }

        TreeNode left = find(node.left, curr + 1, max);
        TreeNode right = find(node.right, curr + 1, max);

        if (left == null || right == null) {
            return left == null ? right : left;
        }

        return node;
    }

    private int findMaxdepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = findMaxdepth(node.left);
        int right = findMaxdepth(node.right);

        return 1 + Math.max(left, right);
    }

}