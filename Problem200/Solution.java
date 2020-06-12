/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int numIslands(char[][] grid)
    {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        int count = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    count++;
                    dfs(i, j, grid, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid, int m, int n)
    {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0')
        {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j, grid, m, n);
        dfs(i - 1, j, grid, m, n);
        dfs(i, j + 1, grid, m, n);
        dfs(i, j - 1, grid, m, n);
    }
}