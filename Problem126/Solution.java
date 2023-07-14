import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();


        Map<String, List<String>> graph = generateGraph(beginWord, new HashSet<>(wordList));

        List<String> ans = new ArrayList<>();
        ans.add(endWord);
        backtrack(endWord, beginWord, result, ans, graph);

        return result;
    }

    private void backtrack(String current, String beginWord, List<List<String>> result, List<String> ans, Map<String,
            List<String>> graph) {
        if (current.equals(beginWord)) {
            List<String> tmp = new ArrayList<>(ans);
            Collections.reverse(tmp);
            result.add(tmp);
            return;
        }

        if (!graph.containsKey(current)) {
            return;
        }


        for (String next : graph.get(current)) {
            ans.add(next);
            backtrack(next, beginWord, result, ans, graph);
            ans.remove(ans.size() - 1);
        }

    }

    private Map<String, List<String>> generateGraph(String begin, Set<String> words) {
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        words.remove(begin);

        Map<String, List<String>> graph = new HashMap<>();

        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> visited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();


                List<String> neighbours = getNeighbours(curr, words);

                for (String next : neighbours) {
                    if (!graph.containsKey(next)) {
                        graph.put(next, new ArrayList<>());
                    }

                    graph.get(next).add(curr);
                    if (visited.add(next)) {
                        q.add(next);
                    }
                }
            }

            words.removeAll(visited);
        }

        return graph;
    }

    private List<String> getNeighbours(String word, Set<String> wordList) {
        List<String> neighbours = new ArrayList<>();

        for (String other : wordList) {
            if (other.equals(word)) {
                continue;
            }

            if (isNeighbour(other, word)) {
                neighbours.add(other);
            }
        }

        return neighbours;
    }

    private boolean isNeighbour(String word1, String word2) {
        int count = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }

        return count < 2;
    }

}