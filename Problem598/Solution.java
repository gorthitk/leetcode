
public class Solution
{
    public int maxCount(int m, int n, int[][] ops)
    {
        int minRow = m - 1, minCol = n - 1;
        for (int[] op : ops)
        {
            minRow = op[0] - 1 >= 0 && op[0] - 1 < m ? Math.min(op[0] - 1, minRow) : minRow;
            minCol = op[1] - 1 >= 0 && op[1] - 1 < n ? Math.min(op[1] - 1, minCol) : minCol;
        }
        return (minRow + 1) * (minCol + 1);
    }
}