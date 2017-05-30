public class Solution {
	public boolean isPerfectSquare(int num) {
		long start = 1, end = num;
		while (start <= end) {
			long mid = start + (end - start) / 2;
			long sqrMid = mid * mid;
			if (sqrMid == num) {
				return true;
			} else if (sqrMid < num) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
}