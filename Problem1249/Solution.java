import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        // Evaluate what parantheses need to removed.
        Set<Integer> removeIdx = new HashSet<>();
        Stack<Integer> open = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case '(':
                    open.add(i);
                    break;
                case ')':
                    if (open.isEmpty()) {
                        removeIdx.add(i);
                    } else {
                        open.pop();
                    }
                    break;
                default:
                    continue;
            }
        }

        while (!open.isEmpty()) {
            removeIdx.add(open.pop());
        }


        // Reconstruct the string with parantheses removed.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (removeIdx.contains(i)) {
                continue;
            }

            sb.append(s.charAt(i));
        }


        return sb.toString();
    }
}
