import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n < 2) {
            for (int i = 0; i < n; i++) {
                leaves.add(i);
            }
            return leaves;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new HashSet<>()).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int num = n;
        while (num > 2) {
            num -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                for (int nbr : graph.get(leaf)) {
                    graph.get(nbr).remove(leaf);
                    if (graph.get(nbr).size() == 1) {
                        newLeaves.add(nbr);
                    }
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}