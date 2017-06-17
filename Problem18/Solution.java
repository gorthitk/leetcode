
public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		for (int i = 0; i < nums.length-3; i++) {
			threeSum(i, nums, target, result);
		}
		return new ArrayList<>(result);
	}

	private void threeSum(int idx, int[] nums, int target, Set<List<Integer>> result) {
		for (int i = idx + 1; i < nums.length-2; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k] + nums[idx] - target;
				if (sum == 0) {
					result.add(Arrays.asList(nums[idx], nums[i], nums[j], nums[k]));
				}
				j = sum < 0 || sum == 0 ? j + 1 : j;
				k = sum > 0 || sum == 0 ? k - 1 : k;
			}
		}

	}
}