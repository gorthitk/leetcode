class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();

        Stack<int[]> stack = new Stack<>();
        // int[] -> alphabet idx, count
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (!stack.isEmpty() && stack.peek()[0] == idx) {
                int[] current = stack.pop();
                if (current[1] == k - 1) {
                    continue;
                }
                stack.add(new int[] {idx, 1 + current[1]});
            } else {
                stack.add(new int[] {idx, 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            int[] current = stack.pop();
            int idx = current[0], count = current[1];

            for (int i = 1; i <= count; i++) {
                sb.append((char)('a' + idx));
            }
        }

        return sb.reverse().toString();
    }
}
