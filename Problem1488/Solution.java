import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public int[] avoidFlood(int[] rains)
    {
        final int n = rains.length;
        final TreeSet<Integer> dryDays = new TreeSet<>();
        final Map<Integer, Integer> filled = new HashMap<>(); // lake to day

        final int[] result = new int[n];

        for (int i = 0; i < n; i++)
        {
            if (rains[i] == 0)
            {
                dryDays.add(i);
                result[i] = 1;
                continue;
            }


            // If it rained
            int lake = rains[i];
            result[i] = -1;


            if (!filled.containsKey(lake))
            {
                filled.put(lake, i);
                continue;
            }


            final int dayTheLakeWasFilled = filled.get(lake);
            if (dryDays.isEmpty())
            {
                return new int[0];
            }

            Integer dayToDry = dryDays.ceiling(dayTheLakeWasFilled);
            if (dayToDry == null)
            {
                return new int[0];
            }

            result[dayToDry] = lake;
            dryDays.remove(dayToDry);
            filled.put(lake, i);
        }


        return result;
    }
}