class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] inDegree = new int[numCourses];
        for (int[] req : prerequisites) {
            graph.computeIfAbsent(req[1], key -> new ArrayList<>())
                    .add(req[0]);
            inDegree[req[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int k = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            result[k++] = curr;

            if (!graph.containsKey(curr)) {
                continue;
            }

            for (int next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return k == numCourses ? result : new int[]{};
    }
}