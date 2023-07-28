class Solution {
    int max = 0;

    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        findDepth(root);

        return max;
    }

    private int findDepth(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.children == null || node.children.isEmpty()) {
            return 1;
        }

        int max1 = 0, max2 = 0;
        for (Node child : node.children) {
            int d = findDepth(child);
            if (d > max1) {
                max2 = max1;
                max1 = d;
            } else {
                if (d > max2) {
                    max2 = d;
                }
            }
        }

        max = Math.max(max1 + max2, max);
        return 1 + max1;
    }
}