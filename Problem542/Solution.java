public class Solution
{
    public int[][] updateMatrix(int[][] matrix)
    {

        int row = matrix.length;
        int column = matrix[0].length;
        int max = row * column;

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                if (matrix[i][j] != 0)
                {
                    int up = i > 0 ? matrix[i - 1][j] : max;
                    int left = j > 0 ? matrix[i][j - 1] : max;
                    matrix[i][j] = Math.min(up, left) + 1;
                }
            }
        }

        for (int i = row - 1; i >= 0; i--)
        {
            for (int j = column - 1; j >= 0; j--)
            {
                if (matrix[i][j] != 0)
                {
                    int down = i < row - 1 ? matrix[i + 1][j] : max;
                    int right = j < column - 1 ? matrix[i][j + 1] : max;
                    matrix[i][j] = Math.min(Math.min(down, right) + 1, matrix[i][j]);
                }
            }
        }

        return matrix;
    }
}