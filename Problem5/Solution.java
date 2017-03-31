public class Solution {
	public String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		int longestPalindromeLen = 0;
		for (int i = 0; i < s.length(); i++) {
			int lenWithCenterAtChar = findPalindromeLength(s, i, i);
			int lenWithCenterBetween = findPalindromeLength(s, i, i + 1);
			int localLongestPalidromelen = Math.max(lenWithCenterAtChar, lenWithCenterBetween);
			if (localLongestPalidromelen > longestPalindromeLen) {
				longestPalindromeLen = localLongestPalidromelen;
				start = i - (localLongestPalidromelen - 1) / 2;
				end = i + (localLongestPalidromelen / 2);
			}
		}
		return s.substring(start, end + 1);
	}

	private int findPalindromeLength(String str, int start, int end) {
		int len = 0;
		while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
			end++;
			start--;
		}
		len = end - start - 1;
		return len;
	}
}