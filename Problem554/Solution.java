import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution
{
    public int leastBricks(List<List<Integer>> wall)
    {
        int min = wall.size();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (List<Integer> row : wall)
        {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++)
            {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (Integer s : map.keySet())
        {
            min = Math.min(min, wall.size() - map.get(s));
        }
        return min;
    }
}