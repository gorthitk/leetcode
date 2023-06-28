class Solution {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root, null, 0);
        return max;
    }

    public void helper(TreeNode node, TreeNode parent, int depth) {
        if (node == null) {
            return;
        }

        int d = parent != null && parent.val + 1 == node.val ? depth + 1 : 1;
        max = Math.max(max, d);

        helper(node.left, node, d);
        helper(node.right, node, d);
    }

}