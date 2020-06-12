/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public void setZeroes(int[][] matrix)
    {
        boolean[] flipRow = new boolean[matrix.length];
        boolean[] flipCol = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    flipRow[i] = true;
                    flipCol[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (flipRow[i] || flipCol[j])
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}