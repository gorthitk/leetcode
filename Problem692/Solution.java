import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution
{
    private static final Comparator<Entry<String, Long>> COMPARATOR =
            (o1, o2) -> o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : Long.compare(o2.getValue(), o1.getValue());

    public List<String> topKFrequent(String[] words, int k)
    {
        final PriorityQueue<Map.Entry<String, Long>> priorityQueue = new PriorityQueue<>(COMPARATOR);

        priorityQueue.addAll(
                Arrays.stream(words)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // collect frequency of words to a map.
                        .entrySet()); // add the entry sets to the queue.

        final List<String> result = new LinkedList<>();
        while (result.size() < k)
        {
            result.add(priorityQueue.poll().getKey());
        }

        return result;
    }
}