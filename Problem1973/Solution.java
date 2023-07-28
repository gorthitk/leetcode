class Solution {
    int count = 0;

    public int equalToDescendants(TreeNode root) {
        findSum(root);
        return count;
    }

    private int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findSum(root.left);
        int right = findSum(root.right);

        if (root.val == left + right) {
            count++;
        }

        return root.val + left + right;
    }
}