/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public int deleteTreeNodes(int nodes, int[] parent, int[] value)
    {
        for (int i = nodes - 1; i > 0; i--)
        {
            value[parent[i]] += value[i];
        }
        if (value[0] == 0)
        {
            return 0;
        }
        int count = 1;
        for (int i = 1; i < nodes; i++)
        {
            if (value[i] != 0 && value[parent[i]] != 0)
            {
                count++;
            }
            else
            {
                value[i] = 0;
            }
        }
        return count;
    }
}