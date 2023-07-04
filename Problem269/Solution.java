class Solution {
    boolean foundInvalid = false;
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        Map<Character, List<Character>> graph = generateGraph(words, inDegree);

        if (foundInvalid) {
            return "";
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char)(i + 'a');
            if (inDegree[i] == 0 && graph.containsKey(ch)) {
                queue.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int sz = queue.size();
            while(sz-- > 0) {
                char curr = queue.poll();
                sb.append(curr);

                for (char next : graph.get(curr)) {
                    inDegree[next - 'a']--;
                    if (inDegree[next - 'a'] == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }

    private Map<Character, List<Character>> generateGraph(String[] words, int[] inDegree) {
        Map<Character, List<Character>> graph = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new ArrayList<>());
            }
        }

        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            String first = words[i], second = words[i + 1];
            int len = Math.min(first.length(), second.length());
            boolean foundMisMatch = false;
            for (int j = 0; j < len; j++) {
                char c1 = first.charAt(j);
                char c2 = second.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree[c2 - 'a']++;
                    foundMisMatch = true;
                    break;
                }
            }

            if (!foundMisMatch && first.length() > second.length()) {
                foundInvalid = true;
            }
        }

        return graph;
    }
}