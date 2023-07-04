import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // O(n.log(k))
        for (int num : nums) {
            pq.add(num);

            while (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}