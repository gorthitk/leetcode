import java.util.HashMap;
import java.util.Map;

/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public String[] getFolderNames(String[] names)
    {
        final Map<String, Integer> seen = new HashMap<>();
        final int n = names.length;
        final String[] result = new String[n];

        for (int i = 0; i < n; i++)
        {
            String name = names[i];
            if (!seen.containsKey(name))
            {
                seen.put(name, 1);
                result[i] = name;
                continue;
            }

            int k = seen.get(name);
            while (seen.containsKey(name + "(" + k + ")"))
            {
                k++;
            }

            seen.put(name, k + 1);
            seen.put(name + "(" + k + ")", 1);
            result[i] = name + "(" + k + ")";
        }

        return result;
    }
}