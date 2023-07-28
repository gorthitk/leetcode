import java.util.*;

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>())
                    .add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>())
                    .add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();
        for (int node : restricted) {
            seen.add(node);
        }

        if (seen.contains(0)) {
            return 0;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int count = 0;
        seen.add(0);

        while (!q.isEmpty()) {
            int curr = q.poll();

            count++;

            if (!graph.containsKey(curr)) {
                continue;
            }

            for (int child : graph.get(curr)) {
                if (seen.add(child)) {
                    q.add(child);
                }
            }
        }

        return count;
    }
}