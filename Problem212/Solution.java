/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.ArrayList;
import java.util.List;

class Solution
{
    private int n;
    private int m;

    public List<String> findWords(char[][] board, String[] words)
    {
        n = board.length;
        m = board[0].length;
        final Trie root = _buildTrie(words);
        final List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                _find(i, j, board, root, result);
                if (result.size() == words.length)
                {
                    break;
                }
            }
        }
        return result;
    }

    private void _find(final int i, final int j, final char[][] board, final Trie dictionary, final List<String> result)
    {
        if (i < 0 || j < 0 || i >= n || j >= m)
        {
            return;
        }
        char ch = board[i][j];
        if (ch > 'z' || ch < 'a')
        {
            return;
        }
        final Trie next = dictionary.children[ch - 'a'];
        if (next == null)
        {
            return;
        }
        if (next.isEnd && !next.added)
        {
            result.add(next.word);
            next.added = true;
        }
        board[i][j] = '#';
        _find(i + 1, j, board, next, result);
        _find(i - 1, j, board, next, result);
        _find(i, j + 1, board, next, result);
        _find(i, j - 1, board, next, result);
        board[i][j] = ch;
    }

    private Trie _buildTrie(final String[] words)
    {
        final Trie root = new Trie();
        for (String word : words)
        {
            _populate(root, word);
        }
        return root;
    }

    private void _populate(final Trie root, String word)
    {
        Trie current = root;
        for (char c : word.toCharArray())
        {
            if (current.children[c - 'a'] == null)
            {
                current.children[c - 'a'] = new Trie();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
        current.word = word;
    }

    class Trie
    {
        Trie[] children = new Trie[26];
        boolean isEnd;
        String word;
        boolean added;
    }
}