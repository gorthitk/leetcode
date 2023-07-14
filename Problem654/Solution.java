class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }

    private TreeNode create(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int maxIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = create(nums, start, maxIdx - 1);
        node.right = create(nums, maxIdx + 1, end);

        return node;
    }
}