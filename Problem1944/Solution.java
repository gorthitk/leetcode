class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = heights.length;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            int current = heights[i];
            while(!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
                count++;
            }

            count += (stack.isEmpty() ? 0 : 1);
            stack.add(current);

            result[i] = count;
        }

        return result;
    }
}