public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] { -1, -1 };
		binarySearch(nums, target, 0, nums.length - 1, result);
		return result;
	}

	private void binarySearch(int[] nums, int target, int start, int end, int[] result) {
		if (start < 0 || end >= nums.length || start > end)
			return;
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			int i = mid - 1;
			int j = mid + 1;
			while (i >= 0 && nums[i] == target)
				i--;
			while (j < nums.length && nums[j] == target)
				j++;
			result[0] = i + 1;
			result[1] = j - 1;
		} else if (nums[mid] > target) {
			binarySearch(nums, target, start, mid - 1, result);
		} else {
			binarySearch(nums, target, mid + 1, end, result);
		}
	}
}