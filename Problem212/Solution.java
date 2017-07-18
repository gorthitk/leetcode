import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Solution.Node;
import Solution.Trie;

public class Solution {
	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie(words);
		if (board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
		HashSet<String> result = new HashSet<>();
		boolean[][] added = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, added, trie, "", result);
			}
		}
		return new ArrayList<>(result);
	}

	private void dfs(char[][] board, int i, int j, boolean[][] added, Trie trie, String current, HashSet<String> result) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || added[i][j]) return;
		added[i][j] = true;
		String next = current + board[i][j];
		Object[] check = trie.check(next);
		if ((boolean) check[0]) {
			if((boolean) check[1]) {
				result.add(next);
			}
			dfs(board, i+1, j, added, trie, next, result);
			dfs(board, i-1, j, added, trie, next, result);
			dfs(board, i, j+1, added, trie, next, result);
			dfs(board, i, j-1, added, trie, next, result);
		}
		added[i][j] = false;
	}

	class Trie {
		Node root;

		public Trie(String[] words) {
			root = new Node();
			for (String word : words) {
				Node current = root;
				for (int i = 0; i < word.length(); i++) {
					int chrIdx = word.charAt(i) - 'a';
					if (current.children[chrIdx] == null) {
						current.children[chrIdx] = new Node();
					}
					current = current.children[chrIdx];
					if (i == word.length()-1) current.endOfWord = true;
				}
			}
		}

		public Object[] check(String word) {
			Node current = root;
			for (int i = 0; i < word.length(); i++) {
				int chrIdx = word.charAt(i) - 'a';
				if (current.children[chrIdx] == null) {
					return new Object[] {false, false};
				}
				current = current.children[chrIdx];
			}
			return new Object[] {true, current.endOfWord};
		}
	}

	class Node {
		Node[] children = new Node[26];
		boolean endOfWord = false;
	}
}