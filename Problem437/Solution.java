import Solution.TreeNode;

public class Solution {

	public int pathSum(TreeNode root, int sum) {
		return root == null ? 0 : getCount(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	private int getCount(TreeNode node, int sum) {
		return node == null ? 0
				: (node.val == sum ? 1 : 0) + getCount(node.left, sum - node.val)
						+ getCount(node.right, sum - node.val);
	}
}