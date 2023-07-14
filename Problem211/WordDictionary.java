class WordDictionary {
    private final Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie current = root;

        for (char ch : word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new Trie();
            }

            current.len[word.length()]++;
            current = current.children[ch - 'a'];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }


    private boolean search(char[] arr, int idx, Trie current) {
        if (idx == arr.length) {
            return current.isEnd;
        }

        char ch = arr[idx];
        if (ch != '.') {
            if (current.children[ch - 'a'] == null) {
                return false;
            }

            return search(arr, idx + 1, current.children[ch - 'a']);
        }


        for (int i = 0; i < 26; i ++) {
            if (current.children[i] == null) {
                continue;
            }

            if(current.len[arr.length] == 0) {
                continue;
            }


            if (search(arr, idx + 1, current.children[i])) {
                return true;
            }
        }

        return false;
    }


    static class Trie {
        Trie[] children = new Trie[26];
        int[] len = new int[26];
        boolean isEnd = false;
    }
}