class Solution {
    int result = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        find(root.left, root.val, root.val);
        find(root.right, root.val, root.val);
        return result;
    }


    private void find(TreeNode node, int max, int min) {
        if (node == null) {
            return;
        }

        int localMax = Math.max(
                Math.abs(node.val - max),
                Math.abs(node.val - min)
        );


        result = Math.max(result, localMax);

        find(node.left, Math.max(max, node.val), Math.min(min, node.val));
        find(node.right, Math.max(max, node.val), Math.min(min, node.val));

    }
}