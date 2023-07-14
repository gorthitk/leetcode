import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n + 1];

        for (int[] relation : relations) {
            int prev = relation[0], next = relation[1];

            graph.computeIfAbsent(prev, key -> new ArrayList<>()).add(next);

            inDegree[next]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }


        int visited = 0;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                visited++;
                int curr = queue.poll();

                if (graph.containsKey(curr)) {
                    for (int next : graph.get(curr)) {
                        inDegree[next]--;

                        if (inDegree[next] == 0) {
                            queue.add(next);
                        }
                    }
                }

            }

            steps++;
        }


        return visited == n ? steps : -1;
    }
}