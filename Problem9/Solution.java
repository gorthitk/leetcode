public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		
		int places = 1;
		while (x / places >= 10) {
			places = places * 10;
		}
		while (x != 0) {
			int tail = x % 10;
			int head = x/places;
			if (tail != head) {
				return false;
			}
			x = (x % places) / 10;
			places = places / 100;
		}
		return true;
	}
}