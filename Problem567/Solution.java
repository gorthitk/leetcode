public class Solution {

	public boolean checkInclusion(String s1, String s2) {
		int[] counts = new int[26];
		for (char c : s1.toCharArray()) {
			counts[c-'a']++;
		}
		
		char[] stream = s2.toCharArray();
		int i = 0;
		int n = s2.length();
		while(i < n) {
			while(i < n && counts[stream[i]-'a'] == 0) {
				i++;
			}
			if (i ==n || n-i < s1.length()) {
				break;
			}
			int[] localCounts = new int[26];
			while(i < n && counts[stream[i]-'a'] != 0 && localCounts[stream[i]-'a'] < counts[stream[i]-'a']) {
				localCounts[stream[i]-'a']++;
				i++;
			}
			boolean exists = true;
			for (int j = 0;j < 26; j++) {
				if (counts[j]!= localCounts[j]) {
					exists = false;
					break;
				}
			}
			if (exists) return true;
		}
		return false;
	}
}