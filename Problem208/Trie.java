public class Trie
{
    Node root;

    public Trie()
    {
        root = new Node();
    }

    public void insert(String word)
    {
        Node current = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null)
            {
                current.children[c - 'a'] = new Node();
            }
            current = current.children[c - 'a'];
            if (i == word.length() - 1)
            {
                current.endOfWord = true;
            }
        }
    }

    public boolean search(String word)
    {
        Node current = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null)
            {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix)
    {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if (current.children[c - 'a'] == null)
            {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return true;
    }

    class Node
    {
        Node[] children;
        boolean endOfWord = false;

        public Node()
        {
            super();
            children = new Node[26];
        }

    }
}