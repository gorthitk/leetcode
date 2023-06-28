class Solution {

    TreeNode last;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode();
        last = dummy;

        inorder(root);
        return dummy.right;
    }


    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        root.left = null;
        last.right = root;
        last = root;

        inorder(root.right);
    }
}