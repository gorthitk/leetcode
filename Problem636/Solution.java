import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int previous = 0;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (String log : logs) {
            String[] parts = log.split(":");
            int jobId = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[2]);

            if (parts[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - previous;
                }

                stack.add(jobId);
                previous = time;
            } else {
                result[stack.pop()] += time - previous + 1;
                previous = time + 1;
            }
        }

        return result;
    }
}