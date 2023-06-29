import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static class Trie {
        Trie[] children;
        boolean isEnd;

        Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }
    }

    private static Trie construct(List<String> wordDict) {
        Trie root = new Trie();

        for (String word : wordDict) {
            int len = word.length();
            Trie current = root;

            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';

                if (current.children[idx] == null) {
                    current.children[idx] = new Trie();
                }

                current = current.children[idx];
                if (i == len - 1) {
                    current.isEnd = true;
                }
            }
        }

        return root;
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie root = construct(wordDict);

        Set<String> result = new HashSet<>();
        find(s, 0, root, result, new ArrayList<>());

        return new ArrayList<>(result);
    }

    private void find(String s, int idx, Trie root, Set<String> result, List<String> sb) {

        if (idx == s.length()) {
            result.add(String.join(" ", sb));
            return;
        }

        Trie current = root;

        for (int i = idx; i < s.length(); i++) {
            int currIdx = s.charAt(i) - 'a';

            if (current.children[currIdx] == null) {
                break;
            }

            current = current.children[currIdx];

            if (current.isEnd) {
                sb.add(s.substring(idx, i + 1));

                find(s, i + 1, root, result, sb);

                sb.remove(sb.size() - 1);
            }
        }
    }
}