public class Solution {
	private int leftMostLevel = 0;
	private int leftMostValue;

	public int findBottomLeftValue(TreeNode root) {
		getLeftMostVal(root, 0);
		return leftMostValue;
	}

	private void getLeftMostVal(TreeNode node, int currLvl) {
		if (node == null)
			return;
		if (leftMostLevel < currLvl && node.left == null && node.right == null) {
			leftMostLevel = currLvl;
			leftMostValue = node.val;
		}
		getLeftMostVal(node.left, currLvl + 1);
		getLeftMostVal(node.right, currLvl + 1);
	}
}