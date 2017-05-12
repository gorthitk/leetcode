import java.util.*;

public class Solution {
	private int maxCount = Integer.MIN_VALUE;

	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		getSums(root, map);
		List<Integer> list = new ArrayList<>();
		map.forEach((k, v) -> {
			if (v == maxCount) {
				list.add(k);
			}
		});
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			result[i] = list.get(i);
		return result;
	}

	private int getSums(TreeNode root, Map<Integer, Integer> map) {
		int sum = root == null ? 0 : root.val + getSums(root.left, map) + getSums(root.right, map);
		if (root != null) {
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			maxCount = Math.max(maxCount, map.get(sum));
		}
		return sum;
	}
}
