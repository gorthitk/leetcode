import java.util.Arrays;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		Arrays.sort(strs, (a, b) -> a.compareTo(b));
		int j = 0, k = 0;
		while (j < strs[0].length() && k < strs[strs.length-1].length() && strs[0].charAt(j) == strs[strs.length-1].charAt(k)) {
			j++;
			k++;
		}
		return strs[0].substring(0, j);
	}
}