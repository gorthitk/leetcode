import java.util.*;

public class Solution
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level1 = Arrays.asList(1);
        List<Integer> level2 = Arrays.asList(1, 1);
        if (numRows <= 0)
        {
            return result;
        }
        result.add(level1);
        if (numRows == 1)
        {
            return result;
        }
        result.add(level2);
        if (numRows == 2)
        {
            return result;
        }
        for (int i = 2; i <= numRows; i++)
        {
            List<Integer> pascalLvl = new ArrayList<>();
            pascalLvl.add(1);
            for (int j = 1; j < i; j++)
            {
                pascalLvl.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }
            pascalLvl.add(1);
            result.add(pascalLvl);
        }
        return result;
    }
}