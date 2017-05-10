import Solution.TreeNode;

public class Solution {
	private int sum = 0;
	public int sumNumbers(TreeNode root) {
		getSum(root, 0);
		return sum;
	}
	private void getSum(TreeNode root, int curr) {
		if(root == null) return;
		curr = curr*10 + root.val;
		if (root.left == null && root.right == null) {
			sum += curr;
			return;
		}
		getSum(root.left, curr);
		getSum(root.right, curr);
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}