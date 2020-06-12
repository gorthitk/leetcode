/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution
{
    public int leastInterval(char[] tasks, int n)
    {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks)
        {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>()
        {
            @Override
            public int compare(Character o1, Character o2)
            {
                return map.get(o2) - map.get(o1);
            }
        });
        for (char task : map.keySet())
        {
            queue.add(task);
        }
        int count = 0;
        while (!queue.isEmpty())
        {
            List<Character> completedTask = new ArrayList<>();
            while (completedTask.size() < n + 1 && !queue.isEmpty())
            {
                completedTask.add(queue.poll());
            }
            for (char chr : completedTask)
            {
                if (map.get(chr) > 1)
                {
                    map.put(chr, map.getOrDefault(chr, 0) - 1);
                    queue.add(chr);
                }
                else
                {
                    map.remove(chr);
                }
            }
            count += completedTask.size() + (!queue.isEmpty() ? n + 1 - completedTask.size() : 0);
        }
        return count;
    }
}