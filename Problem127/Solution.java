import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = populateGraph(beginWord, wordList); // O(m2l)
        if (!graph.containsKey(endWord) || graph.get(beginWord).size() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                visited.add(curr);
                if (!graph.containsKey(curr)) {
                    continue;
                }

                for (String next : graph.get(curr)) {
                    if (next.equals(endWord)) {
                        return level + 1;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    queue.add(next);
                }
            }

            level++;
        }

        return 0;
    }

    private Map<String, List<String>> populateGraph(String beginWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();

        // Populate Neighbours based on the word list.
        int n = wordList.size();
        for (int i = 0; i < n; i++) {
            String w1 = wordList.get(i);
            graph.putIfAbsent(w1, new ArrayList<>());
            for (int j = i + 1; j < n; j++) {
                String w2 = wordList.get(j);
                if (isNeighbour(w1, w2)) {
                    graph.get(w1).add(w2);
                    graph.computeIfAbsent(w2, key -> new ArrayList<>()).add(w1);
                }
            }
        }

        graph.put(beginWord, new ArrayList<>());
        for (String word : wordList) {
            if (graph.containsKey(word) && // Ignore words that don't offer any transformations.
                    isNeighbour(word, beginWord)) {
                graph.get(word).add(beginWord);
                graph.get(beginWord).add(word);
            }
        }

        return graph;
    }

    private boolean isNeighbour(String w1, String w2) {
        int count = 0;
        int n = w1.length();
        for (int i = 0; i < n; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}