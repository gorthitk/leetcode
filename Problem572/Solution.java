
public class Solution {
	public static void main(String args[]) {
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(1);
		s.right.left = new TreeNode(2);
		
		
		TreeNode t = new TreeNode(3);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		Solution sol = new Solution();
		System.out.println(sol.isSubtree(s, t));
	}
	public boolean isSubtree(TreeNode s, TreeNode t) {
		return isSubtree(s, t, false);
	}

	private boolean isSubtree(TreeNode s, TreeNode t, boolean partialMatch) {
		if ((s == null && t != null) || (s != null && t == null) ) {
			return false;
		}
		if (s == null && t == null) return true;
		if (t.val == s.val && isSubtree(s.left, t.left, true) && isSubtree(s.right, t.right, true)) {
				return true;
		}
		if (partialMatch) return false;
		return isSubtree(s.left, t) || isSubtree(s.right, t);
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