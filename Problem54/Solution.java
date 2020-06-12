/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return new ArrayList<>();
        }
        return getSpiralOrder(0, 0, matrix.length - 1, matrix[0].length - 1, matrix);
    }

    private List<Integer> getSpiralOrder(int minRow, int minCol, int maxRow, int maxCol, int[][] matrix)
    {
        List<Integer> result = new ArrayList<Integer>();
        if (minRow > maxRow || minCol > maxCol)
        {
            return result;
        }
        if (minRow <= maxRow && minCol <= maxCol)
        {
            for (int i = minCol; i <= maxCol; i++)
            {
                result.add(matrix[minRow][i]);
            }
            minRow++;
            for (int i = minRow; i <= maxRow; i++)
            {
                result.add(matrix[i][maxCol]);
            }
            maxCol--;
            if (minRow <= maxRow)
            {
                for (int i = maxCol; i >= minCol; i--)
                {
                    result.add(matrix[maxRow][i]);
                }
            }
            maxRow--;
            if (minCol <= maxCol)
            {
                for (int i = maxRow; i >= minRow; i--)
                {
                    result.add(matrix[i][minCol]);
                }
            }
            minCol++;
            result.addAll(getSpiralOrder(minRow, minCol, maxRow, maxCol, matrix));
        }
        return result;
    }
}