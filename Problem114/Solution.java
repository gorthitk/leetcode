public class Solution {
	public void flatten(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return;
		flatten(root.left);
		flatten(root.right);
		TreeNode currRight = root.right;
		root.right = root.left;
		root.left = null;
		while(root.right != null) root = root.right;
		root.right = currRight;
	}
}