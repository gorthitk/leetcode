class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val >= maxSoFar) {
            count++;
        }

        count += dfs(node.left, Math.max(node.val, maxSoFar));
        count += dfs(node.right, Math.max(node.val, maxSoFar));

        return count;
    }
}