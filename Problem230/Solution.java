public class Solution {
	private int kthSmallest;

	public int kthSmallest(TreeNode root, int k) {
		getKthElement(root, k, 0);
		return kthSmallest;
	}

	private int getKthElement(TreeNode root, int k, int curr) {
		if (root == null)
			return curr;
		curr = getKthElement(root.left, k, curr);
		curr++;
		if (curr == k) {
			kthSmallest = root.val;
			return curr;
		}
		return getKthElement(root.right, k, curr);
	}
}