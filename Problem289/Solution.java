public class Solution
{

    public void gameOfLife(int[][] board)
    {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        int[][] next = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int countLiveNeighbours = 0;
                countLiveNeighbours += i - 1 < 0 ? 0 : board[i - 1][j];
                countLiveNeighbours += j - 1 < 0 ? 0 : board[i][j - 1];
                countLiveNeighbours += i + 1 >= m ? 0 : board[i + 1][j];
                countLiveNeighbours += j + 1 >= n ? 0 : board[i][j + 1];
                countLiveNeighbours += i - 1 < 0 || j - 1 < 0 ? 0 : board[i - 1][j - 1];
                countLiveNeighbours += i + 1 >= m || j - 1 < 0 ? 0 : board[i + 1][j - 1];
                countLiveNeighbours += i - 1 < 0 || j + 1 >= n ? 0 : board[i - 1][j + 1];
                countLiveNeighbours += i + 1 >= m || j + 1 >= n ? 0 : board[i + 1][j + 1];
                next[i][j] = board[i][j];
                next[i][j] = countLiveNeighbours < 2 || countLiveNeighbours > 3 ? 0 : next[i][j];
                if (board[i][j] == 0 && countLiveNeighbours == 3)
                {
                    next[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                board[i][j] = next[i][j];
            }
        }
    }
}