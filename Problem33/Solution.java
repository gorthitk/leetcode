public class Solution {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		int n = nums.length;

		int low = 0;
		int hi = n-1;
		while (low < hi) {
			int mid = (low+hi)/2;
			if (nums[mid] > nums[hi]) {
				low = mid+1;
			} else {
				hi = mid;
			}
		}
		return getTargetIdx(nums, target < nums[0] ? low : 0, target > nums[n-1] ? low-1 : nums.length - 1, target);
	}

	private int getTargetIdx(int[] nums, int start, int end, int target) {
		if (start > end)return -1;
		int mid = start + (end - start) / 2;
		return nums[mid] == target ? mid : nums[mid] < target ? getTargetIdx(nums, mid + 1, end, target) : getTargetIdx(nums, start, mid - 1, target);
	}

}