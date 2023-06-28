class Solution {

    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return result;
    }

    private int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }


        int left = longestPath(node.left);
        int right = longestPath(node.right);

        result = Math.max(result, 1 + left + right);


        return 1 + Math.max(left, right);
    }

}