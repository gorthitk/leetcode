class BrowserHistory
{
    Node root;
    Node current;

    public BrowserHistory(String homepage)
    {
        root = new Node(homepage);
        current = root;
    }

    public void visit(String url)
    {
        final Node node = new Node(url);

        current.next = node;
        node.prev = current;

        current = node;
    }

    public String back(int steps)
    {
        while (current.prev != null && steps-- > 0)
        {
            current = current.prev;
        }

        return current.url;
    }

    public String forward(int steps)
    {
        while (current.next != null && steps-- > 0)
        {
            current = current.next;
        }

        return current.url;
    }

    class Node
    {
        private final String url;

        Node prev;
        Node next;

        Node(String url)
        {
            this.url = url;
        }
    }
}