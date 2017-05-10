import java.util.*;

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		populateInOrder(root, list);

		return list;
	}

	private void populateInOrder(TreeNode root, List<Integer> list) {
		if (root != null) {
			list.add(root.val);
			populateInOrder(root.left, list);
			populateInOrder(root.right, list);
			return;
		}
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