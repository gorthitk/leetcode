class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] requirement : prerequisites) {
            graph
                    .computeIfAbsent(requirement[1], key -> new ArrayList<>())
                    .add(requirement[0]);

            indegree[requirement[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            visited++;
            if (!graph.containsKey(current)) {
                continue;
            }

            for (int dependent : graph.get(current)) {
                indegree[dependent]--;
                if (indegree[dependent] == 0) {
                    queue.add(dependent);
                }
            }
        }



        return visited == numCourses;
    }
}