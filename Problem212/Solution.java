import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end;

        static void addToTrie(String word, TrieNode parent) {
            TrieNode current = parent;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (current.children[idx] == null) {
                    current.children[idx] = new TrieNode();
                }
                current = current.children[idx];
            }
            current.end = true;
        }
    }

    public List<String> findWords(char[][] board, String[] wordsArr) {
        TrieNode parent = new TrieNode();
        for (String word : wordsArr) {
            TrieNode.addToTrie(word, parent);
        }
        int n = board.length, m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < m; j++) {
                backtrack(i, j, "", board, visited, result, parent);
            }
        }
        return new ArrayList<>(result);
    }

    private void backtrack(int i, int j, String current, char[][] board,
                           boolean[][] visited, Set<String> result, TrieNode currentNode) {
        if (currentNode.end) {
            result.add(current);
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        char ch = board[i][j];
        TrieNode next = currentNode.children[ch - 'a'];
        if (next == null) {
            return;
        }

        // Set the next arguments.
        visited[i][j] = true;
        StringBuilder sb = new StringBuilder(current);
        sb.append(ch);

        backtrack(i - 1, j, sb.toString(), board, visited, result, next);
        backtrack(i + 1, j, sb.toString(), board, visited, result, next);
        backtrack(i, j - 1, sb.toString(), board, visited, result, next);
        backtrack(i, j + 1, sb.toString(), board, visited, result, next);

        // Reset arguments.
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}