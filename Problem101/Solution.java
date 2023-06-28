class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }


    private boolean isMirror(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }

        if (p1 == null || p2 == null) {
            return false;
        }

        return p1.val == p2.val && isMirror(p1.left, p2.right)
                && isMirror(p1.right, p2.left);
    }
}