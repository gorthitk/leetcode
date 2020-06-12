/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int[][] generateMatrix(int n)
    {
        if (n <= 0)
        {
            return new int[][]{{}};
        }
        int[][] matrix = new int[n][n];
        generateSpiralMatrix(0, 0, matrix.length - 1, matrix[0].length - 1, matrix, 1);
        return matrix;
    }

    private void generateSpiralMatrix(int minRow, int minCol, int maxRow, int maxCol, int[][] matrix, int next)
    {
        if (minRow > maxRow || minCol > maxCol)
        {
            return;
        }
        if (minRow <= maxRow && minCol <= maxCol)
        {
            for (int i = minCol; i <= maxCol; i++)
            {
                matrix[minRow][i] = next++;
            }
            minRow++;
            for (int i = minRow; i <= maxRow; i++)
            {
                matrix[i][maxCol] = next++;
            }
            maxCol--;
            if (minRow <= maxRow)
            {
                for (int i = maxCol; i >= minCol; i--)
                {
                    matrix[maxRow][i] = next++;
                }
            }
            maxRow--;
            if (minCol <= maxCol)
            {
                for (int i = maxRow; i >= minRow; i--)
                {
                    matrix[i][minCol] = next++;
                }
            }
            minCol++;
            generateSpiralMatrix(minRow, minCol, maxRow, maxCol, matrix, next);
        }
    }
}