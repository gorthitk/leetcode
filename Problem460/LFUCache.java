

import java.util.*;

public class LFUCache
{
    int capacity;
    Map<Integer, Integer> frequency;
    Map<Integer, Integer> times;
    Map<Integer, Integer> lookUpTable;
    PriorityQueue<Integer> queue;
    int time = 0;

    public LFUCache(int capacity)
    {
        this.capacity = capacity;
        frequency = new HashMap<>();
        lookUpTable = new HashMap<>();
        times = new HashMap<>();
        queue = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return frequency.get(o1) != frequency.get(o2) ? frequency.get(o1) - frequency.get(o2) :
                        times.get(o1) - times.get(o2);
            }
        });
    }

    public int get(int key)
    {
        if (!lookUpTable.containsKey(key) || capacity == 0)
        {
            return -1;
        }
        frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        times.put(key, time++);
        queue.remove(key);
        queue.add(key);
        return lookUpTable.get(key);
    }

    public void put(int key, int value)
    {
        if (capacity == 0)
        {
            return;
        }
        if (lookUpTable.containsKey(key))
        {
            queue.remove(key);
        }
        if (queue.size() == capacity && !lookUpTable.containsKey(key))
        {
            int removed = queue.poll();
            lookUpTable.remove(removed);
            frequency.remove(removed);
            times.remove(removed);
        }
        lookUpTable.put(key, value);
        frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        times.put(key, time++);
        queue.add(key);
    }
}