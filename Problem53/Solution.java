public class Solution {
	public int maxSubArray(int[] nums) {
		int max = nums[0], localSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			localSum = Math.max(localSum + nums[i], nums[i]);
			max = Math.max(max, localSum);
		}
		return max;
	}
}