/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution
{
    public int[][] matrixReshape(int[][] nums, int r, int c)
    {
        if (nums == null || nums.length == 0 || nums[0].length == 0)
        {
            return nums;
        }
        int rows = nums.length;
        int columns = nums[0].length;
        if (rows * columns != r * c)
        {
            return nums;
        }
        int[][] matrix = new int[r][c];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                matrix[i][j] = queue.poll();
            }
        }
        return matrix;
    }
}