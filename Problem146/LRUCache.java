/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class LRUCache
{
    long time = 0;
    int capacity;
    Map<Integer, Integer> lookUp;
    Map<Integer, Long> used;
    PriorityQueue<Integer> queue;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        lookUp = new HashMap<>();
        used = new HashMap<>();
        queue = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return (int) (used.get(o1) - used.get(o2));
            }
        });
    }

    public int get(int key)
    {
        if (lookUp.containsKey(key))
        {
            used.put(key, time++);
            queue.remove(key);
            queue.add(key);
            return lookUp.get(key);
        }
        return -1;
    }

    public void put(int key, int value)
    {
        if (!lookUp.containsKey(key) && lookUp.size() == this.capacity)
        {
            int removed = queue.poll();
            lookUp.remove(removed);
            used.remove(removed);
            queue.remove(removed);
        }
        queue.remove(key);
        lookUp.put(key, value);
        used.put(key, time++);
        queue.add(key);
    }
}