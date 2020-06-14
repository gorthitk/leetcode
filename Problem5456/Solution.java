/**
 * @author tgorthi
 * @since Jun 2020
 */
class TreeAncestor
{
    private final int[] parent;
    private final int[] depth;

    public TreeAncestor(int n, int[] parent)
    {
        this.parent = parent;
        this.depth = new int[n];

        for (int i = 1; i < parent.length; i++)
        {
            _findDepth(i);
        }
    }

    private int _findDepth(int node)
    {
        if (node == 0)
        {
            return 0;
        }

        if (depth[node] != 0)
        {
            return depth[node];
        }

        depth[node] = _findDepth(parent[node]) + 1;
        return depth[node];
    }

    public int getKthAncestor(int node, int k)
    {
        if (depth[node] < k)
        {
            return -1;
        }

        int ancestor = node;
        while (k > 0 && ancestor >= 0)
        {
            ancestor = parent[ancestor];
            k--;
        }

        return ancestor;
    }
}