class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        add(root, 0);
        return result;
    }


    private void add(TreeNode node, int curr) {
        if (node == null) {
            return;
        }

        int next = curr * 10 + node.val;
        if (node.left == null && node.right == null) {
            result += next;
            return;
        }

        add(node.left, next);
        add(node.right, next);
    }
}