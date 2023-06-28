import java.util.List;

class Solution {

    class TrieNode {

        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        TrieNode root = new TrieNode();
        populate(root, wordDict);

        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || dp[i - 1]) {
                TrieNode curr = root;
                for (int j = i; j < n; j++) {
                    int idx = arr[j] - 'a';
                    if (curr.children[idx] == null) {
                        break;
                    }

                    curr = curr.children[idx];
                    if (curr.isEnd) {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[n-1];
    }

    private void populate(TrieNode root, List<String> wordDict) {
        for (String word : wordDict) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }

                curr = curr.children[idx];
                if (i == word.length() - 1) {
                    curr.isEnd = true;
                }
            }
        }
    }
}