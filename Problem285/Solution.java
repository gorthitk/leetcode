class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }


        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }


        TreeNode suc = inorderSuccessor(root.left, p);
        return suc != null ? suc : root;
    }
}