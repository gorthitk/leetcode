public class Solution
{
    public boolean exist(char[][] board, String word)
    {

        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (checkIfExists(board, i, j, word, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkIfExists(char[][] board, int i, int j, String word, int k)
    {
        if (k == word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        if (word.charAt(k) != board[i][j])
            return false;
        char tmp = board[i][j];
        board[i][j] = '!';
        boolean exists = checkIfExists(board, i + 1, j, word, k + 1) || checkIfExists(board, i - 1, j, word, k + 1)
                || checkIfExists(board, i, j + 1, word, k + 1) || checkIfExists(board, i, j - 1, word, k + 1);
        board[i][j] = tmp;
        return exists;
    }
}