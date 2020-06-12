/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public int maxAreaOfIsland(int[][] grid)
    {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1)
                {
                    maxArea = Math.max(maxArea, getArea(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    private int getArea(int i, int j, int[][] grid)
    {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
        {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + getArea(i + 1, j, grid) + getArea(i - 1, j, grid) + getArea(i, j + 1, grid) + getArea(i, j - 1, grid);
    }
}