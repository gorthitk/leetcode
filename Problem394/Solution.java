import java.util.HashMap;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int maxLen = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int idx = 0;
		while (idx <= s.length()) {
			if (idx == s.length()) {
				int len = idx - start;
				maxLen = Math.max(maxLen, len);
				break;
			}
			char c = s.charAt(idx);
			if (map.containsKey(c) && map.get(c) >= start) {
				int len = idx - start;
				maxLen = Math.max(maxLen, len);
				start = map.get(c) + 1;
			}
			map.put(c, idx);
			idx++;
		}
		return maxLen;
	}
}