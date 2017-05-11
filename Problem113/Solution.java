import java.util.*;

public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new ArrayList<>();
		getPaths(root, sum, new ArrayList<Integer>(), paths);
		return paths;
	}

	private void getPaths(TreeNode root, int sum, ArrayList<Integer> arrayList, List<List<Integer>> paths) {
		if (root == null)
			return;
		arrayList.add(root.val);
		if (sum == root.val && root.left == null && root.right == null) {
			paths.add(arrayList);
			return;
		}
		getPaths(root.left, sum - root.val, new ArrayList<>(arrayList), paths);
		getPaths(root.right, sum - root.val, new ArrayList<>(arrayList), paths);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}