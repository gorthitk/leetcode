

import java.util.List;

public class ZigzagIterator
{
    private final List<Integer> list1;
    private final List<Integer> list2;
    int list1Index = 0;
    int list2Index = 0;
    int currentList = -1;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2)
    {
        this.list1 = v1;
        this.list2 = v2;
        currentList = !v1.isEmpty() ? 1 : !v2.isEmpty() ? 2 : -1;
    }

    public int next()
    {
        if (currentList == 1)
        {
            int value = list1.get(list1Index++);
            if (list2Index == list2.size())
            {
                currentList = list1Index == list1.size() ? -1 : 1;
            }
            else
            {
                currentList = 2;
            }
            return value;
        }
        if (currentList == 2)
        {
            int value = list2.get(list2Index++);
            if (list1Index == list1.size())
            {
                currentList = list2Index == list2.size() ? -1 : 2;
            }
            else
            {
                currentList = 1;
            }
            return value;
        }
        return -1;
    }

    public boolean hasNext()
    {
        return currentList != -1;
    }
}