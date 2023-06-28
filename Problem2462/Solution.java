import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> head = new PriorityQueue<>();
        PriorityQueue<Integer> tail = new PriorityQueue<>();

        int n = costs.length, start = 0, end = n - 1;

        while (start < n && head.size() < candidates) {
            head.add(costs[start++]);
        }

        while (end > start && tail.size() < candidates) {
            tail.add(costs[end--]);
        }

        long cost = 0;

        for (int i = 0; i < k; i++) {
            if (tail.isEmpty() || (!head.isEmpty() && head.peek() <= tail.peek())) {
                cost += head.poll();
                if (start <= end) {
                    head.add(costs[start++]);
                }
            } else {
                cost += tail.poll();
                if (end >= start) {
                    tail.add(costs[end--]);
                }
            }
        }

        return cost;
    }
}