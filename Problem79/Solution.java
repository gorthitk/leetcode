/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word)
    {
        int a = board.length;
        int b = board[0].length;
        for (int i = 0; i < a; i++)
        {
            for (int j = 0; j < b; j++)
            {
                if (matches(i, j, board, word, 0, a, b))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean matches(int i, int j, char[][] board, String word, int index, int a, int b)
    {
        if (index == word.length())
        {
            return true;
        }
        if (i >= a || j >= b || i < 0 || j < 0)
        {
            return false;
        }
        char curr = word.charAt(index);
        if (board[i][j] == curr)
        {
            board[i][j] = '*';
            for (int[] direction : directions)
            {
                if (matches(i + direction[0], j + direction[1], board, word, index + 1, a, b))
                {
                    return true;
                }
            }
            board[i][j] = curr;
        }
        return false;
    }
}