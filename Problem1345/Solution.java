import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> indexes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexes.computeIfAbsent(arr[i], key -> new ArrayList<>())
                    .add(i);
        }


        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return steps;
                }

                visited[curr] = true;

                for (int nbr : getNeighbours(arr, curr, indexes)) {
                    if (visited[nbr]) {
                        continue;
                    }
                    queue.add(nbr);
                }

                indexes.get(arr[curr]).clear();
            }


            steps++;

        }


        return -1;
    }

    private static List<Integer> getNeighbours(int[] arr, int idx, Map<Integer, List<Integer>> indexes) {
        List<Integer> list = new ArrayList<>();

        if (idx + 1 < arr.length) {
            list.add(idx + 1);
        }


        if (idx - 1 >= 0) {
            list.add(idx - 1);
        }

        for (int i : indexes.get(arr[idx])) {
            if (i != idx) {
                list.add(i);
            }
        }

        return list;
    }
}