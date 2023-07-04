import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>()).add(ticket.get(1));
        }


        List<String> result = new ArrayList<>();
        dfs("JFK", graph, result);


        Collections.reverse(result);
        return result;
    }


    private void dfs(String current, Map<String, PriorityQueue<String>> graph, List<String> result) {
        if (graph.containsKey(current)) {
            PriorityQueue<String> queue = graph.get(current);
            while (!queue.isEmpty()) {
                dfs(queue.poll(), graph, result);
            }
        }


        result.add(current);
    }
}