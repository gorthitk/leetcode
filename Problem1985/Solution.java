class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>(
                (a,b) -> {
                    if (a.length() == b.length()) {
                        return a.compareTo(b);
                    }

                    return a.length() < b.length() ? -1 : 1;
                }
        );


        for (String num : nums) {
            queue.add(num);
        }

        while (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }
}