import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public int findLeastNumOfUniqueInts(int[] arr, int k)
    {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : arr)
        {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }


        int min = counter.size();

        var sorted = counter.keySet()
                .stream()
                .sorted(Comparator.comparingInt(counter::get))
                .collect(Collectors.toList());


        for (int i = 0; i < sorted.size(); i++)
        {
            int num = sorted.get(i);
            int sz = counter.get(num);

            if (sz <= k)
            {
                k -= sz;
                min--;
            }
        }

        return min;
    }
}