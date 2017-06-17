public class Solution {
	public int characterReplacement(String s, int k) {
		int maxLen = 0, maxCount = 0, start = 0;
		int[] count = new int[26];
		for (int end = 0; end < s.length(); end++) {
			maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
			while (end - start - maxCount + 1 > k) count[s.charAt(start++) - 'A']--;
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}
}