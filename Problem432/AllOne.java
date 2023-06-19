

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AllOne
{
    private Map<String, Integer> map;
    private PriorityQueue<String> maxQueue;
    private PriorityQueue<String> minQueue;

    public AllOne()
    {
        map = new HashMap<String, Integer>();
        maxQueue = new PriorityQueue<>(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return map.get(o1) - map.get(o2);
            }
        });
        minQueue = new PriorityQueue<>(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return map.get(o2) - map.get(o1);
            }
        });
    }

    public void inc(String key)
    {
        map.put(key, map.getOrDefault(key, 0) + 1);
        maxQueue.remove(key);
        minQueue.remove(key);
        maxQueue.add(key);
        minQueue.add(key);
    }

    public void dec(String key)
    {
        if (map.containsKey(key))
        {
            maxQueue.remove(key);
            minQueue.remove(key);
            if (map.get(key) == 1)
            {
                map.remove(key);
            }
            else
            {
                map.put(key, map.get(key) - 1);
                maxQueue.add(key);
                minQueue.add(key);
            }
        }
    }

    public String getMaxKey()
    {
        return maxQueue.isEmpty() ? "" : maxQueue.peek();
    }

    public String getMinKey()
    {
        return minQueue.isEmpty() ? "" : minQueue.peek();
    }
}