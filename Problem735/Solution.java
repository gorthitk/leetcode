class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            int num = asteroids[i];
            boolean addToStack = true;
            // check if a collision can happen.
            while (!stack.isEmpty() && stack.peek() > 0 && num < 0) {
                int numAbs = Math.abs(num);

                if (numAbs > stack.peek()) {
                    stack.pop();
                    continue;
                }

                // If the value if less than or equal,
                // dont add to stack , since the asteriod will be destroyed.

                // If equal remove both asteroids.
                if (numAbs == stack.peek()) {
                    stack.pop();
                }

                addToStack = false;
                break;
            }

            if (addToStack) {
                stack.add(num);
            }
        }


        int m = stack.size();
        int[] result = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}