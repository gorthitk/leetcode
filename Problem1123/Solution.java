class Solution {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        int left = findMaxDepth(root.left, 1);
        int right = findMaxDepth(root.right, 1);

        if (left == right) {
            return root;
        }

        return left > right ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
    }


    private int findMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }

        int left = findMaxDepth(root.left, depth + 1);
        int right = findMaxDepth(root.right, depth + 1);

        return Math.max(left, right);
    }
}