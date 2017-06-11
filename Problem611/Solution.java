import java.util.Arrays;

public class Solution {
	public int triangleNumber(int[] nums) {
		if (nums == null || nums.length < 3) return 0;
		int count = 0;
		int n = nums.length;
		Arrays.sort(nums);
		for (int i = 2; i < n; i++) {
			int a = nums[i];
			int l = 0;
			int r = i - 1;
			while (l < r) {
				int b = nums[l];
				int c = nums[r];
				int sum = b + c;
				if (sum > a) {
					count+=(r-l);
					r--;
				} else {
					l++;
				}
			}
		}
		return count;
	}
}