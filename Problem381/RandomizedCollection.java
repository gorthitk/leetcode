

import java.util.*;

public class RandomizedCollection
{
    List<Integer> list;
    Map<Integer, HashSet<Integer>> indices;
    Random rand = new Random();

    public RandomizedCollection()
    {
        list = new ArrayList<Integer>();
        indices = new HashMap<Integer, HashSet<Integer>>();
    }

    public boolean insert(int val)
    {
        boolean duplicate = indices.containsKey(val);
        indices.putIfAbsent(val, new LinkedHashSet<>());
        indices.get(val).add(list.size());
        list.add(val);
        return !duplicate;
    }

    public boolean remove(int val)
    {
        if (!indices.containsKey(val))
        {
            return false;
        }
        int idx = indices.get(val).iterator().next();
        indices.get(val).remove(idx);
        if (idx < list.size() - 1)
        {
            int replaceVal = list.get(list.size() - 1);
            list.set(idx, replaceVal);
            indices.get(replaceVal).remove(list.size() - 1);
            indices.get(replaceVal).add(idx);
        }
        list.remove(list.size() - 1);
        if (indices.get(val).isEmpty())
        {
            indices.remove(val);
        }
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom()
    {
        return list.get(rand.nextInt(list.size()));
    }
}