
public class Solution
{
    public boolean isValidSerialization(String preorder)
    {
        String[] nodes = preorder.split(",");
        int expectedNodes = 1;
        for (String node : nodes)
        {
            if (--expectedNodes < 0)
            {
                return false;
            }
            expectedNodes += node.equals("#") ? 0 : 2;
        }
        return expectedNodes == 0;
    }
}