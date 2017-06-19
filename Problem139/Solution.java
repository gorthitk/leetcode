import java.util.*;

public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		return dynamicSolution(s, wordDict);
		//return breakWords(s, wordDict, new ArrayList<>(), 0);
	}

	//Dynamic
	private boolean dynamicSolution(String s, List<String> wordDict) {
		int n = s.length();
		boolean dp[] = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				String word = s.substring(j, i);
				if (dp[j] && wordDict.contains(word)) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

	// Recursive
	private boolean breakWords(String s, List<String> wordDict, List<String> current, int startIdx) {
		if (startIdx == s.length())
			return true;
		for (int i = startIdx + 1; i <= s.length(); i++) {
			String word = s.substring(startIdx, i);
			if (wordDict.contains(word)) {
				current.add(word);
				boolean otherWordsLegal = breakWords(s, wordDict, current, i);
				if (otherWordsLegal)
					return true;
				current.remove(word);
			}
		}
		return false;
	}
}