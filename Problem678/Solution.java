class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> wild = new Stack<>();
        Stack<Integer> open = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                wild.push(i);
            } else if (ch == '(') {
                open.push(i);
            } else {
                if (open.isEmpty() && wild.isEmpty()) {
                    return false;
                }

                if (!open.isEmpty()) {
                    open.pop();
                } else {
                    wild.pop();
                }
            }
        }

        while (!open.isEmpty()) {
            if (wild.isEmpty()) {
                break;
            }

            if (wild.peek() < open.peek()) {
                break;
            }

            wild.pop();
            open.pop();
        }

        return open.isEmpty();
    }
}