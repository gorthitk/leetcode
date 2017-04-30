public class Solution {

	public int subarraySum(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k)
				count++;
			int localSum = sum;
			int start = 0;
			while (start < i) {
				localSum = localSum - nums[start];
				if (localSum == k)
					count++;
				start++;
			}

		}
		return count;
	}

}