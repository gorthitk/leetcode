import Solution1.TreeNode;

public class Solution1 {
	public int findTilt(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))  {
			return 0;
		}
		return getTilt(root)[0];
	}

	private int[] getTilt(TreeNode root) {
		int[] tilt = new int[2];
		if (root == null) {
			return tilt;
		}
		
		int[] left = getTilt(root.left);
		int[] right = getTilt(root.right);
		tilt[0] = left[0] + right[0] + Math.abs(left[1] - right[1]);
		tilt[1] = left[1] + right[1] + root.val;
		return tilt;
	}
	 public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
}