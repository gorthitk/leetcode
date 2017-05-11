import java.util.*;

import Solution.MyQueue;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		MyQueue<TreeNode> queue = new MyQueue<>();
		queue.addIfNotNull(root);
		while (!queue.isEmpty()) {
			MyQueue<TreeNode> nextLevel = new MyQueue<>();
			List<Integer> currentLevel = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				currentLevel.add(node.val);
				nextLevel.addIfNotNull(node.left);
				nextLevel.addIfNotNull(node.right);
			}
			result.add(currentLevel);
			queue = nextLevel;
		}
		return result;
	}

	public class MyQueue<E> extends LinkedList<E> {
		private static final long serialVersionUID = 1L;

		public void addIfNotNull(E e) {
			if (e != null) {
				add(e);
			}
		}
	}
}