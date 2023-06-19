

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution
{
    public int minTime(int n, int[][] edges, List<Boolean> hasApple)
    {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++)
        {
            graph.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            graph.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        return _compute(0, graph, hasApple, new boolean[n]);
    }

    private int _compute(int index, Map<Integer, List<Integer>> graph, List<Boolean> hasApple, boolean[] visited)
    {
        if (!graph.containsKey(index))
        {
            return 0;
        }
        visited[index] = true;
        int count = 0;
        for (int child : graph.get(index))
        {
            if (visited[child])
            {
                continue;
            }
            count += _compute(child, graph, hasApple, visited);
            if (hasApple.get(child))
            {
                hasApple.set(index, true);
                count += 2;
            }
        }
        return count;
    }
}